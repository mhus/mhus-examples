package de.mhus.examples.vaadin2;

import java.util.LinkedList;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

// https://vaadin.com/components/vaadin-combo-box

public class PanelCombobox extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public PanelCombobox() {
        {
            ComboBox<String> cb = new ComboBox<String>("Browsers");
            cb.setItems("Google Chrome", "Mozilla Firefox", "Opera","Apple Safari", "Microsoft Edge");
            cb.addValueChangeListener(event -> {
                if (event.getSource().isEmpty())
                    Notification.show("No browser selected");
                else
                    Notification.show("Selected browser: " + event.getValue());
            });
            add(cb);
        }

        {
            ComboBox<String> cb = new ComboBox<String>("Browsers");
            cb.setItems("Google Chrome", "Mozilla Firefox", "Opera","Apple Safari", "Microsoft Edge");
            cb.addValueChangeListener(event -> {
                if (event.getSource().isEmpty())
                    Notification.show("No browser selected");
                else
                    Notification.show("Selected browser: " + event.getValue());
            });
            cb.setClearButtonVisible(true);
            add(cb);
        }

        {
            ComboBox<String> cb = new ComboBox<String>("Browsers");
            cb.setItems("Google Chrome", "Mozilla Firefox", "Opera","Apple Safari", "Microsoft Edge");
            cb.addValueChangeListener(event -> {
                if (event.getSource().isEmpty())
                    Notification.show("No browser selected");
                else
                    Notification.show("Selected browser: " + event.getValue());
            });
            cb.setEnabled(false);
            add(cb);
        }

        {
            ComboBox<Song> comboBox = new ComboBox<>();
            comboBox.setLabel("Music selection");
            comboBox.setItemLabelGenerator(Song::getName);

            List<Song> listOfSongs = new LinkedList<>();
            listOfSongs.add(new Song("Mercedes Benz","?","Janis Joplin"));
            listOfSongs.add(new Song("Lookin' for a Reason","Mardi Gras","Creedence Clearwater Revival"));
            
            comboBox.setItems(listOfSongs);
            comboBox.addValueChangeListener(event -> {
                Song song = comboBox.getValue();
                if (song != null) {
                    Notification.show("Selected song: " + song.getName()
                            + "\nFrom album: " + song.getAlbum() + "\nBy artist: "
                            + song.getArtist());
                } else {
                    Notification.show("No song is selected");
                }
            });
            add(comboBox);
        }
        
    }
    
    private static class Song {
        private String name;
        private String album;
        private String artist;
        
        public Song(String name, String album, String artist) {
            super();
            this.name = name;
            this.album = album;
            this.artist = artist;
        }
        public String getName() {
            return name;
        }
        public String getAlbum() {
            return album;
        }
        public String getArtist() {
            return artist;
        }
        
    }
}
