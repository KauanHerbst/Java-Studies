import java.sql.*;

public class mainDAO {
    static Connection conexao = null;
    public static void main(String[] args) {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Tests", "postgres", "");
            Statement stm = conexao.createStatement();
            retornarQuery(stm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(conexao != null){
                try {
                    conexao.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static void retornarQuery(Statement stm) {
        String sql = "SELECT * FROM tb_pessoas";
        try{
            ResultSet result = stm.executeQuery(sql);
            while (result.next()){
                System.out.println("nome: " + result.getString("nome"));
                System.out.println("idade: " + result.getInt("idade"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
