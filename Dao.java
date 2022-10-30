import java.sql.*;


public class Dao {
    public static void connectDB(){

        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Successfully connected");
            /*
            String queue = "INSERT INTO funcionarios (codigo,primeironome,segundonome,ultimonome,endereco,cidade,fone,codigodepartamento,funcao,salario) VALUES ('1','Luciano','Freire','da Silvera','Rua josé infermeior 80','São Cristovão','000000','6','toplaner','1400');";

            Statement statement = connection.createStatement();

            int rows =  statement.executeUpdate(queue);
            if(rows >0){
                System.out.println("Inserted");
            }
            */
            String  queue = "SELECT * FROM funcionarios";
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(queue);

            while (result.next()){
                int id = result.getInt("codigo");
                String firstname = result.getString("primeironome");
                String middledname = result.getString("segundonome");
                String lastname = result.getString("ultimonome");
                String  address = result.getString("endereco");
                String city = result.getString("cidade");
                String fone = result.getString("codigodepartamento");
                String function = result.getString("funcao");
                String salario  = result.getString("salario");

                System.out.printf("%d - %s - %s - %s - %s - %s - %s - %s - %s\n",id,firstname,middledname,lastname,address,city,fone,function,salario);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("error connecting to database");
            throw new RuntimeException(e);
        }
    }
}