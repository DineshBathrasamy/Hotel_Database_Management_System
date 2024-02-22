package JDBCProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


	class HotelData{
		int hotelId;
		String hotelName;
		String hotelLocation;
		int noOfRoomAvailable;
		int costPerRoom;
		
		static HashMap<Integer, HotelData> hotelDatabase = new HashMap<Integer, HotelData>();
	
	
		
		public static void toCreateAHotel(){
			HotelData HDatabase=new HotelData();
			Scanner input = new Scanner(System.in);
			
			System.out.println(" ʜᴏᴛᴇʟ ɴᴀᴍᴇ  : ");
			HDatabase.hotelName=input.next();
			
			System.out.println(" ʜᴏᴛᴇʟ ʟᴏᴄᴀᴛɪᴏɴ : ");
			HDatabase.hotelLocation=input.next();
			
			System.out.print("ɴᴜᴍʙᴇʀ ᴏғ ʀᴏᴏᴍs ᴀᴠᴀɪʟᴀʙʟᴇ : ");
			HDatabase.noOfRoomAvailable=input.nextInt();
			
			System.out.println("ᴄᴏsᴛ ᴘᴇʀ ʀᴏᴏᴍ : ");
			HDatabase.costPerRoom=input.nextInt();
			
			HDOperations.toAddAHotel(HDatabase);
			
			System.out.println(" ʜᴏᴛᴇʟ ᴄʀᴇᴀᴛᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ  ");
			
		}
	    
		public static void toRemoveAHotel(){
			Scanner input = new Scanner(System.in);
			System.out.println(" ᴇɴᴛᴇʀ ᴀɴ ɪᴅ ᴛᴏ ʙᴇ ʀᴇᴍᴏᴠᴇᴅ : ");
			int id = input.nextInt();
			if (HDOperations.studentExists(id)) {
				HDOperations .toRemoveHotel(id);
				System.out.println(" ʜᴏᴛᴇʟ ᴡɪᴛʜ " + id + " ʜᴀs  ʀᴇᴍᴏᴠᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ ");

			}else {
				System.err.println(" ʜᴏᴛᴇʟ ᴡɪᴛʜ " + id + " ᴅᴏᴇs ɴᴏᴛ ᴇxɪsᴛ!!! ");

			}
			
		}

		public static void toUpdateAHotel(){
			Scanner input = new Scanner(System.in);
			System.out.println(" ᴇɴᴛᴇʀ ᴀɴ ɪᴅ ᴛᴏ ʙᴇ ᴜᴘᴅᴀᴛᴇᴅ: ");
			int id = input.nextInt();

			if (HDOperations.studentExists(id)) {
				
				System.out.println("𝟷. ᴜᴘᴅᴀᴛᴇ ʜᴏᴛᴇʟ ɴᴀᴍᴇ");
				System.out.println("𝟸. ᴜᴘᴅᴀᴛᴇ ʟᴏᴄᴀᴛɪᴏɴ");
				System.out.println("𝟹. ᴜᴘᴅᴀᴛᴇ ɴᴜᴍʙᴇʀ ᴏғ ʀᴏᴏᴍs ");
				System.out.println("𝟺. ᴜᴘᴅᴀᴛᴇ ᴄᴏsᴛ ᴏғ ʀᴏᴏᴍ");
				System.out.println("ᴇɴᴛᴇʀ ᴀ ᴄʜᴏɪᴄᴇ:");
				
				int choice =input.nextInt();
				switch (choice) {
				case 1:
					System.out.print("ᴇɴᴛᴇʀ ᴀ ɴᴀᴍᴇ ᴛᴏ ʙᴇ ᴜᴘᴅᴀᴛᴇᴅ :");
					HDOperations.toUpdateName(id, input.next());
					break;
				case 2:
					System.out.print("ᴇɴᴛᴇʀ ᴀ ʟᴏᴄᴀᴛɪᴏɴ ᴛᴏ ʙᴇ ᴜᴘᴅᴀᴛᴇᴅ :");
					HDOperations.toUpdateLocation(id, input.next());
					break;
				case 3:
					System.out.print("ᴇɴᴛᴇʀ  ɴᴜᴍʙᴇʀ ᴏғ ʀᴏᴏᴍs ᴛᴏ ʙᴇ ᴜᴘᴅᴀᴛᴇᴅ : ");
					HDOperations.toUpdatecostPerRoom(id, input.nextInt());
					break;
				case 4:	
					System.out.print("ᴇɴᴛᴇʀ ᴄᴏsᴛ ᴘᴇʀ ʀᴏᴏᴍ ᴛᴏ ʙᴇ ᴜᴘᴅᴀᴛᴇᴅ :");
					HDOperations.toUpdatecostPerRoom(id, input.nextInt());
					break;
				default:
					System.err.println("ᴇɴᴛᴇʀ ᴀ ᴠᴀʟɪᴅ ᴄʜᴏɪᴄᴇ");
					break;
				}
			} else {
				System.err.println("ʜᴏᴛᴇʟ ᴡɪᴛʜ" + id + "ᴅᴏᴇs ɴᴏᴛ ᴇxɪsᴛ!!!");
			}

		}
		
	    public static void toDisplayAHotel(){
	    	HashMap<Integer, HotelData> hoteldb= HDOperations.toGetAllHotelData();
			System.out.println("ᨶꪮꪑᨶꪮꪑᨶꪮᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑ ");
	    	System.out.println("ID  \t    NAME  \t    LOCATION  \t    AVAILABILITY  \t    PRICE");
			System.out.println("ᨶꪮꪑᨶꪮꪑᨶꪮᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑ ");
			for (Map.Entry<Integer, HotelData> hotelEntry : hoteldb.entrySet()) {
				System.out.print(hotelEntry.getKey()+"\t");
				System.out.print(hotelEntry.getValue().hotelName + "  \t   ");
				System.out.print(hotelEntry.getValue().hotelLocation + "    \t    ");
				System.out.print(hotelEntry.getValue().noOfRoomAvailable + "    \t    ");
				System.out.println(hotelEntry.getValue().costPerRoom + "      \t    ");
				System.out.println("ᨶꪮꪑᨶꪮꪑᨶꪮᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑᨶꪮꪑ ");



			}
	    }

	    public static void toSearchAHotel(){
	    	
			Scanner input = new Scanner(System.in);
			System.out.println("ᴇɴᴛᴇʀ ᴀɴ ɪᴅ ᴛᴏ ʙᴇ sᴇᴀʀᴄʜᴇᴅ : ");
			int id=input.nextInt();
			if (HDOperations.studentExists(id)) {
				HotelData HData =HDOperations.toSearchHotel(id);
				System.out.println("ʜᴏᴛᴇʟ ɪᴅ 			      : " + HData.hotelId);
				System.out.println("ʜᴏᴛᴇʟ ɴᴀᴍᴇ 			      : " + HData.hotelName);
				System.out.println("ʜᴏᴛᴇʟ ʟᴏᴄᴀᴛɪᴏɴ 			  : " + HData.hotelLocation);
				System.out.println("ɴᴜᴍʙᴇʀ ᴏғ ʀᴏᴏᴍs ᴀᴠᴀɪʟᴀʙʟᴇ : " + HData.noOfRoomAvailable);
				System.out.println("ᴄᴏsᴛ ᴏғ ʀᴏᴏᴍ 			  : " + HData.costPerRoom);
				System.out.println("sᴛᴜᴅᴇɴᴛ ᴅᴀᴛᴀ ᴘʀɪɴᴛᴇᴅ sᴜᴄᴄᴇssғᴜʟʟʏ!!\n");
			}else {
				System.err.println("ʜᴏᴛᴇʟ ᴡɪᴛʜ" + id + "ᴅᴏᴇs ɴᴏᴛ ᴇxɪsᴛ!!!");
			}
		}

	}


