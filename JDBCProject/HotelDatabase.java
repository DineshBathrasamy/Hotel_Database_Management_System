package JDBCProject;

import java.util.Scanner;

public class HotelDatabase {

	
		
		private static void printMenu() {
			System.out.println("\n𝟷.ʜᴏᴛᴇʟ ᴄʀᴇᴀᴛɪᴏɴ");
			System.out.println("𝟸.ʀᴇᴍᴏᴠᴇ ʜᴏᴛᴇʟ");
			System.out.println("𝟹.ᴜᴘᴅᴀᴛᴇ ʜᴏᴛᴇʟ ᴅᴇᴛᴀɪʟs");
			System.out.println("𝟺.ᴅɪsᴘʟᴀʏ ʜᴏᴛᴇʟ ᴅᴇᴛᴀɪʟs");
			System.out.println("𝟻.sᴇᴀʀᴄʜ ʜᴏᴛᴇʟ ᴅᴇᴛᴀɪʟs");
			System.out.println("𝟼.ᴇxɪᴛ ᴀᴘᴘʟɪᴄᴀᴛɪᴏɴ");
			System.out.print("\n ᴘʟᴇᴀsᴇ ᴇɴᴛᴇʀ ʏᴏᴜʀ ᴄʜᴏɪᴄᴇ : ");
		}

		public static void main(String[] args) {
			
			System.out.println("\t 𝙃𝙤𝙩𝙚𝙡 𝘿𝙖𝙩𝙖𝙗𝙖𝙨𝙚 𝙨𝙮𝙨𝙩𝙚𝙢 ");
			System.out.println("\t----------------");
			
			Scanner input =new Scanner(System.in);
			
			while (true) {
				printMenu();
			
			int choice =input.nextInt();
			switch (choice) {
			case 1:
				HotelData.toCreateAHotel();
				break;
			case 2:
				HotelData.toRemoveAHotel();
				break;
			case 3:
				HotelData.toUpdateAHotel();
				break;
			case 4:
				HotelData.toDisplayAHotel();
				break;
			case 5:
				HotelData.toSearchAHotel();
				break;	
			case 6:
				System.out.println("\n ᨶꪮꪑ ᴀᴘᴘʟɪᴄᴀᴛɪᴏɴ ᴇxɪᴛᴇᴅ ᨶꪮꪑ");
				input.close();
				return;
			default:
				System.err.println("\n sᴏʀʀʏ ʏᴏᴜʀ ᴄʜᴏɪᴄᴇ ɪs ɪɴᴠᴀʟɪᴅ !!!" + "ᴘʟᴇᴀsᴇ ᴇɴᴛᴇʀ ᴀ ᴠᴀʟɪᴅ ᴄʜᴏɪᴄᴇ ");
			}
				
			}
}
}