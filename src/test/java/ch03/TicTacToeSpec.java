package ch03;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;


/**
 * Created by Jowita on 2017-02-06.
 */
public class TicTacToeSpec {

    private TicTacToe tic;

    @Before
    public final void przed(){
        tic = new TicTacToe();
    }

   @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void kiedyZnakPozaOsiaXNadmiarZglosRuntimeException(){
        exception.expect(RuntimeException.class);
        tic.play(4,1);
    }
    @Test
    public void kiedyZnakPozaOsiaXUjemneZglosRuntimeException(){
        exception.expect(RuntimeException.class);
        tic.play(0,1);
    }
    @Test
    public void kiedyZnakPozaOsiaYNadmiarZglosRuntimeException(){
        exception.expect(RuntimeException.class);
        tic.play(1,4);
    }
    @Test
    public void kiedyZnakPozaOsiaYUjemnaZglosRuntimeException(){
        exception.expect(RuntimeException.class);
        tic.play(1,0);
    }
    @Test
    public void kiedyZnakNaZajetymPoluZglosRuntimeException(){
        tic.play(1,1);
        exception.expect(RuntimeException.class);
        tic.play(1,1);
    }

    @Test
    public void zaczynaGraczX(){
        char nastepnyGracz = tic.nextPlayer();
        assertEquals('x', nastepnyGracz);
    }

    @Test
    public void poXjestO(){
        tic.play(1,1);
        char nastepnyGracz = tic.nextPlayer();
        assertEquals('o', nastepnyGracz);
    }

    @Test
    public void poOjestX(){
        tic.play(1,1);
        tic.play(1,2);
        char nastepnyGracz = tic.nextPlayer();// o
        assertEquals('x', nastepnyGracz);
    }

    @Test
    public void poPierwszymZnakuBrakZwyciezcy(){
        String wynikGry = tic.play(1,1);
        assertEquals("Brak zwyciezcy", wynikGry);
    }

    @Test
    public void wygrywaGraczXGdyMaZapelnionyWiersz(){
        tic.play(1,1);
        tic.play(1,3);
        tic.play(2,1);
        tic.play(2,3);
        String wynikGry = tic.play(3,1);
        assertEquals("Zwyciezca X", wynikGry);
    }

    @Test
    public void wygrywaGraczOGdyMaZapelnionyWiersz(){
        tic.play(1,3);//x
        tic.play(1,1);//o
        tic.play(1,2);//x
        tic.play(2,1);//o
        tic.play(3,3);//x
        String wynikGry = tic.play(3,1);//o
        assertEquals("Zwyciezca O", wynikGry);
    }

    @Test
    public void wygrywaGraczXGdyMaZapelnionaKolumne(){
        tic.play(1,1);//x
        tic.play(3,1);//o
        tic.play(1,2);//x
        tic.play(2,2);//o
        String wynikGry = tic.play(1,3);//x
        assertEquals("Zwyciezca X", wynikGry);
    }
    @Test
    public void wygrywaGraczOGdyMaZapelnionaKolumne(){
        tic.play(2,1);//x
        tic.play(1,1);//o
        tic.play(3,1);//x
        tic.play(1,2);//o
        tic.play(2,2);//x
        String wynikGry = tic.play(1,3);//o
        assertEquals("Zwyciezca O", wynikGry);
    }

    @Test
    public void wygrywaGraczXGdyMaZapelnionaPrzekatnaLewa(){
        tic.play(1,1);//x
        tic.play(3,1);//o
        tic.play(2,2);//x
        tic.play(1,2);//o
        String wynikGry = tic.play(3,3);//x
        assertEquals("Zwyciezca X", wynikGry);
    }
    @Test
    public void wygrywaGraczOGdyMaZapelnionaPrzekatnaLewa(){
        tic.play(2,1);//x
        tic.play(1,1);//o
        tic.play(3,1);//x
        tic.play(2,2);//o
        tic.play(1,2);//x
        String wynikGry = tic.play(3,3);//o
        assertEquals("Zwyciezca O", wynikGry);
    }

    @Test
    public void wygrywaGraczXGdyMaZapelnionaPrzekatnaPrawa(){
        tic.play(3,1);//x
        tic.play(1,1);//o
        tic.play(2,2);//x
        tic.play(1,2);//o
        String wynikGry = tic.play(1,3);//x
        assertEquals("Zwyciezca X", wynikGry);
    }
    @Test
    public void wygrywaGraczOGdyMaZapelnionaPrzekatnaPrawa(){
        tic.play(2,1);//x
        tic.play(3,1);//o
        tic.play(1,1);//x
        tic.play(2,2);//o
        tic.play(1,2);//x
        String wynikGry = tic.play(1,3);//o
        assertEquals("Zwyciezca O", wynikGry);
    }
    //  123
    // 1xox
    // 2xox
    // 3oxo
    @Test
    public void remisGdyWszystkiePolaZapelnione(){
        tic.play(1,1);//x
        tic.play(2,1);//o
        tic.play(3,1);//x
        tic.play(2,2);//o
        tic.play(1,2);//x
        tic.play(1,3);//o
        tic.play(3,2);//x
        tic.play(3,3);//o
        String  wynikGry = tic.play(2,3);//x
        assertEquals("Remis", wynikGry);
    }
}
