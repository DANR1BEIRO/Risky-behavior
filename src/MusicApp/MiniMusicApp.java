package MusicApp;

import javax.sound.midi.*;

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp miniMusicApp = new MiniMusicApp();
        miniMusicApp.play();
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, 102, 100);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(128, 1, 29, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 10);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Anatomy of a message
 * The first argument to setMessage() always
 * represents the message “type,” while the other
 * three arguments represent different things
 * depending on the message type.
 *
 *  * The 4 args of a message:
 *
 * setMessage(message type, channel, note to play, velocity)
 *
 * 1 - Message type
 * 144 means NOTE ON (start playing)
 * 128 means NOTE OFF (stop playing)
 * We can use the constant values in ShortMessage instead
 * of having to remember the numbers, e.g., ShortMessage.NOTE_ON/ShortMessage.NOTE_OFF
 *
 * 2 - Channel
 * Think of a channel like a musician in
 * a band. Channel 1 is musician 1 (the
 * keyboard player), channel 9 is the
 * drummer, etc.
 *
 * 3 - Note to play
 * A number from 0 to 127, going
 * from low to high notes.
 *
 * 4 - Velocity
 * How fast and hard did you press the
 * key? 0 is so soft you probably won’t hear
 * anything, but 100 is a good default.
 *
 *
 */