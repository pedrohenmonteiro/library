import db.DB;

public class App {
    public static void main(String[] args) throws Exception {
        var conn = DB.getConnection();
        DB.closeConnection();
    }
}
