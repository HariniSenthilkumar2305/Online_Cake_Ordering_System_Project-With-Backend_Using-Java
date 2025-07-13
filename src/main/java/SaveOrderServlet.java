import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/save-order")
public class SaveOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String deliveryDate = request.getParameter("deliveryDate");
        double cakeWeight = Double.parseDouble(request.getParameter("cakeWeight"));
        String paymentMethod = "Cash on Delivery";

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO orders (product, quantity, price, name, email, phone, address, delivery_date, cake_weight, payment_method) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product);
            ps.setInt(2, quantity);
            ps.setDouble(3, price);
            ps.setString(4, name);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8, deliveryDate);
            ps.setDouble(9, cakeWeight);
            ps.setString(10, paymentMethod);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("OrderPlacedPage.html?product=" + product + "&quantity=" + quantity +
                "&price=" + price + "&address=" + address +
                "&deliveryDate=" + deliveryDate + "&name=" + name);
    }
}
