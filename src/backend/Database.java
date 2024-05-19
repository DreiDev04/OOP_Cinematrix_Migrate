package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String FILE_DIR = System.getProperty("user.dir") + File.separator + "src" + File.separator + "database" + File.separator;
    private static final String CSV_FILE = FILE_DIR + "UserDatabase.csv";
    private static final String CSV_BOOKMARK = FILE_DIR + "BookmarkDB.csv";
    private static final String CSV_FAVORITES = FILE_DIR + "FavoritesDB.csv";

    public Database() {
        if (!fileExists(CSV_FILE)) {
            createCSVFile(CSV_FILE);
        }
//        if (!fileExists(CSV_BOOKMARK)) {
//            createBookmarkDB(CSV_BOOKMARK);
//        }
        if (!fileExists(CSV_FAVORITES)) {
            createFavoritesDB(CSV_FAVORITES);
        }
    }

    public void addUserToDB(UserTemplate user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            bw.write(user.getFieldValue("UID") + "~");
            bw.write(user.getFieldValue("firstName") + "~");
            bw.write(user.getFieldValue("lastName") + "~");
            bw.write(String.valueOf(user.getAge()) + "~");
            bw.write(user.getFieldValue("username") + "~");
            bw.write(user.getFieldValue("password") + "~");
            bw.write(user.getFieldValue("birthDate") + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFavorites(FavoritesTemplate ft) {
        if (!isMovieAlreadyInFavorites(ft.getUID(), ft.getMovieID())) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FAVORITES, true))) {
                bw.write(ft.getUID() + "~");
                bw.write(ft.getMovieID() + "\n");
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Movie already exists in favorites.");
        }
    }

    public List<BookmarkTemplate> getBookmarks() {
        List<BookmarkTemplate> bookmarkList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_BOOKMARK))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("~");
                BookmarkTemplate bookmark = new BookmarkTemplate();
                bookmark.setUID(fields[0]);
                bookmark.setBookmarkID(fields[1]);
                bookmark.setMovieID(fields[2]);
                bookmarkList.add(bookmark);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookmarkList;
    }

    public List<FavoritesTemplate> getFavorites() {
        List<FavoritesTemplate> favoritesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FAVORITES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("~");
                FavoritesTemplate favorites = new FavoritesTemplate();
                favorites.setUID(fields[0]);
                favorites.setMovieID(fields[1]);
                favoritesList.add(favorites);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favoritesList;
    }

    public List<UserTemplate> getUsers() {
        List<UserTemplate> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split("~");
                UserTemplate user = new UserTemplate(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], LocalDate.parse(fields[6]));
                userList.add(user);
                System.out.format("%s\t%s\t%s\t%s\t%s\t%s\t%s%n", fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public UserTemplate getSpesificUser(String UID) {
        UserTemplate userToReturn = new UserTemplate();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split("~");
                UserTemplate user = new UserTemplate(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], fields[5], LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("MM-dd-yyyy")));
                if (UID.equals(user.getUID())) {
                    userToReturn = user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userToReturn;
    }

    private static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    public boolean isUserIDExists(String userID) {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split("~");
                if (fields[0].equals(userID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void createCSVFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("UID~First Name~Last Name~Age~Username~Password~Birthdate\n"); // Header row
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFavoritesDB(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("UID~Movie ID\n"); // Header row
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isMovieAlreadyInFavorites(String UID, String movieID) {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FAVORITES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("~");
                if (fields[0].equals(UID) && fields[1].equals(movieID)) {
                    return true; // Movie already exists in favorites
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }

    public void removeFavorites(String UID, String movieID) {
        List<FavoritesTemplate> favoritesList = getFavorites(); 
        favoritesList.removeIf(favorites -> favorites.getUID().equals(UID) && favorites.getMovieID().equals(movieID));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FAVORITES))) {
            for (FavoritesTemplate favorites : favoritesList) {
                bw.write(favorites.getUID() + "~" + favorites.getMovieID() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
