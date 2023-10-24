package ConnectDB;


public class TestConnection {
    public static void main(String[] args) {
        ConnectDB connectDB = new ConnectDB(); 
        if (connectDB.checkConnect()) {
            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            connectDB.closeConnect();
        } else {
            System.out.println("Kết nối đến cơ sở dữ liệu thất bại!");
        }
    }
}
