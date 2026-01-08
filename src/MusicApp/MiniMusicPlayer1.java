package MusicApp;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer1 {
    public static void main(String[] args) {
        MiniMusicPlayer1 player = new MiniMusicPlayer1();
        player.go();
    }

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // make and open a sequencer
            sequencer.open();

            // Register for events with the sequencer.
            // The event registration method takes the listener AND an int array representing
            // the list of ControllerEvents I want. We want care about one event, #127
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant);
            // Each time we get the event, we'll print "la" to the command line.

            // make a sequence and track
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // Make a bunch of events to make the notes keep going up (from piano note 5 to piano note 61)
            for (int i = 0; i < 61; i += 4) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(command, channel, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}

