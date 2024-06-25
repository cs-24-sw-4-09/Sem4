import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.sound.midi.Receiver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import Util.Flag;
import Util.PlaybackHandler;
import Util.notation.Chord;
import Util.notation.Notation;






@RunWith(MockitoJUnitRunner.class)
public class PlaybackHandlerUnitTest {
    @Mock 
    private Flag flag;
    
    @Mock
    private Receiver receiver;
    
    @Mock
    private Notation notation;

    @Mock
    private Chord chord;



    private PlaybackHandler playbackHandler;
    

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        flag = mock(Flag.class);
        receiver = mock(Receiver.class);
        playbackHandler = new PlaybackHandler(120);
    }

    @Test
    public void registerFlagTest() {
        playbackHandler.registerFlag(flag);
        assertEquals(1, playbackHandler.getActiveFlags().size());
        assertEquals(flag, playbackHandler.getActiveFlags().get(0));
    }

    @Test
    public void unregisterFlagTest() {
        playbackHandler.registerFlag(flag);
        playbackHandler.unregisterFlag(flag);
        assertEquals(0, playbackHandler.getActiveFlags().size());
    }

    //By default we have 16 channel, for sake of test we add 1, which puts us at 17
    @Test
    public void freeChannelTest() {
        playbackHandler.freeChannel(0);
        assertEquals(17, playbackHandler.getFreeChannels().size());
        assertEquals(0, playbackHandler.getFreeChannels().get(0).intValue());
    }


    @Test
    public void requestChannelEmptyTest() throws Exception {
        assertEquals(0, playbackHandler.requestChannel());
    }

    @Test
    public void requestChannelTest() throws Exception {
        playbackHandler.freeChannel(2);
        playbackHandler.requestChannel();
        assertEquals(16, playbackHandler.getFreeChannels().size());
    }

    // triple check this guy
    @Test
    public void addNotationTest() {
        Chord testChord = new Chord(new int[]{100, 200, 150}, 4, Notation.Instrument.PIANO );
        playbackHandler.addNotation("track", testChord);
        assertEquals(1, playbackHandler.getTrackList().size());
        assertEquals(1, playbackHandler.getTrackList().get("track").size());
        assertEquals(testChord.getFlag(), playbackHandler.getTrackList().get("track").get(0));
    }

    
}
