package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        var sql = "INSERT INTO products(title, price) VALUES (?, ?)";

        try (var conn = dataSource.getConnection()) {
            var smtp = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            smtp.setString(1, product.getTitle());
            smtp.setInt(2, product.getPrice());
            smtp.executeUpdate();
            var generatedKeys = smtp.getGeneratedKeys();
            System.out.println(generatedKeys);
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Product> find(long id) throws SQLException {
        var sql = "SELECT * FROM products WHERE id = ?";
        try (var conn = dataSource.getConnection()) {
            var smtp = conn.prepareStatement(sql);
            smtp.setLong(1, id);
            var resultSet = smtp.executeQuery();

            if (resultSet.next()) {
                var title = resultSet.getString("title");
                var price = resultSet.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                return Optional.of(product);
            }

            return Optional.empty();
        }
    }

    public static List<Product> getEntities() throws SQLException {
        var result = new ArrayList<Product>();
        var sql = "SELECT * FROM products";

        try (var conn = dataSource.getConnection()) {
            var smtp = conn.createStatement();
            var resultSet = smtp.executeQuery(sql);

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var title = resultSet.getString("title");
                var price = resultSet.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                result.add(product);
            }
        }

        return result;
    }
    // END
}
