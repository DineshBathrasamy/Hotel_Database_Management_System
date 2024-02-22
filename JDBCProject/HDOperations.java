package JDBCProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class HDOperations {

	private static final String host = "jdbc:mysql://localhost:3306/hoteldb";
	private static final String username = "root";
	private static final String password = "Dinesh_9500748835";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(host, username, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void toAddAHotel(HotelData hotelDatabase) {
		try {
			Connection con = getConnection();
			String query = "Insert into hotel ( hotelName, hotelLocation, noOfRoomAvailable, costPerRoom)"
					+ "values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, hotelDatabase.hotelName);
			stmt.setString(2, hotelDatabase.hotelLocation);
			stmt.setInt(3, hotelDatabase.noOfRoomAvailable);
			stmt.setInt(4, hotelDatabase.costPerRoom);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("ʜᴏᴛᴇʟ ᴄʀᴇᴀᴛɪᴏɴ sᴜᴄᴄᴇssғᴜʟ!!!\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, HotelData> toGetAllHotelData() {
		try {
			Connection con = getConnection();
			String query = "Select * from hotel ";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			HashMap<Integer, HotelData> hotelDatabase = new HashMap<>();
			while (result.next()) {
				HotelData obj = new HotelData();
				obj.hotelId = result.getInt(1);
				obj.hotelName = result.getString(2);
				obj.hotelLocation = result.getString(3);
				obj.noOfRoomAvailable = result.getInt(4);
				obj.costPerRoom = result.getInt(5);
				hotelDatabase.put(obj.hotelId, obj);
			}
			stmt.close();
			con.close();
			return hotelDatabase;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean studentExists(int id) {
		try {
			Connection con = getConnection();
			String query = "Select * from hotel where hotelId= ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			boolean flag = result.next();
			con.close();
             stmt.close();
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void toRemoveHotel(int id) {
		try {
			Connection con = getConnection();
			String query = "Delete from hotel where hotelId= ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("ʜᴏᴛᴇʟ ᴡɪᴛʜ ɪᴅ" + id + "ɪs ʀᴇᴍᴏᴠᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static HotelData toSearchHotel(int id) {
		try {
			Connection con = getConnection();
			String query = "Select * from hotel where hotelId= ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			HotelData hotdata = new HotelData();
			result.next();
			hotdata.hotelId = result.getInt(1);
			hotdata.hotelName = result.getString(2);
			hotdata.hotelLocation = result.getString(3);
			hotdata.noOfRoomAvailable = result.getInt(4);
			hotdata.costPerRoom = result.getInt(5);
			stmt.close();
			con.close();
			return hotdata;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void toUpdateName(int id, String name) {
		try {
			Connection con = getConnection();
			String query = " Update hotel set hotelName = ? where hotelId = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("ʜᴏᴛᴇʟ ɴᴀᴍᴇ ɪs ᴜᴘᴅᴀᴛᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void toUpdateLocation(int id, String Location) {
		try {
			Connection con = getConnection();
			String query = " Update hotel set hotelLocation = ? where hotelId = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, Location);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("ʜᴏᴛᴇʟ ʟᴏᴄᴀᴛɪᴏɴ ɪs ᴜᴘᴅᴀᴛᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void toUpdateNoOfRoomAvailable(int id, int room) {
		try {
			Connection con = getConnection();
			String query = " Update hotel set noOfRoomAvailable = ? where studId = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, room);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("ɴᴜᴍʙᴇʀ ᴏғ ʀᴏᴏᴍ ᴀᴠᴀɪʟᴀʙʟᴇ ɪs ᴜᴘᴅᴀᴛᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void toUpdatecostPerRoom(int id, int cost) {
		try {
			Connection con = getConnection();
			String query = " Update hotel set costPerRoom = ? where studId = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, cost);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("ᴄᴏsᴛ ᴘᴇʀ ʀᴏᴏᴍ ɪs ᴜᴘᴅᴀᴛᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
