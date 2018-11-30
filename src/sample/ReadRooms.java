package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import sample.Global;
import sample.Room;

public class ReadRooms {
  ReadRooms() {

    File roomFile = new File("lib/rooms.txt");
    Scanner scanner = null;
    try {
      scanner = new Scanner(roomFile);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      e.printStackTrace();
    }
    String currentLine;
    ArrayList<Room> rooms = new ArrayList<>();


    int lineNumber = 0;
    int lineNumberForRoom=0;
    Boolean passedLine = false;
    Room createRoom= new Room();
    while(scanner.hasNextLine())
    {
      currentLine = scanner.nextLine();
      lineNumber++;
      //System.out.println( currentLine);
      if(passedLine)
      {
        //System.out.println("Worked!");
        //Do other task after passing the line.
        if(!currentLine.equals("|_End_|"))
        {
          //Not the end of the room data
          //Ok Print room data


         // System.out.println(currentLine + "-"+ lineNumber+ "-"+lineNumberForRoom);
          //passedLine =false;
          if (lineNumberForRoom==1){
            //Room name
            createRoom.setName(currentLine);
            createRoom.setnameProperty(currentLine);


          }
          if (lineNumberForRoom==2){
            //isAvailable
            createRoom.setAvailable(Boolean.valueOf(currentLine));

          }
          if (lineNumberForRoom==3){
            //room price
            createRoom.setPrice(Double.parseDouble(currentLine));


          }
          if (lineNumberForRoom==4){
            //PictureUrl
            createRoom.setPictureUrl(currentLine);

          }
          if (lineNumberForRoom==5){

            //OccipiedGuest may need to check for null
//            assert (currentLine.getClass().equals(Guest.class));
            //createRoom.setOccupiedGuest(currentLine);
            //check guestlist for matching username, then set the matching guest to room
            for (Guest g: Global.guestList){
              System.out.println( g.toString() + "  " + currentLine);
              if (currentLine.equals(g.toString())){
                createRoom.setOccupiedGuest(g);
                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHdid this" + g.getUserName());
              }

            }


          }
          if (lineNumberForRoom==6){
            //totalprice
            createRoom.setTotalPrice(Double.parseDouble(currentLine));

          }
          if (lineNumberForRoom==7){
            //day in
            if (currentLine.equals("null")){
              createRoom.setDayIn(null);
            }else{
              createRoom.setDayIn(LocalDate.parse(currentLine));
            }


          }
          if (lineNumberForRoom==8){
            //day out
            if (currentLine.equals("null")){
              createRoom.setDayOut(null);
            }else {
              createRoom.setDayOut(LocalDate.parse(currentLine));
            }
          }


        }else {
          //Okay stop, current room data is over
         // System.out.println("End of Room Data");
          rooms.add(createRoom);
          passedLine=false;

        }
        lineNumberForRoom++;

      }

      if(currentLine.equals("|_Start_|"))
      {
        //Do task
        createRoom = new Room();
        passedLine = true;
        lineNumberForRoom=1; //starting from 1
        //Room has 4 fields currently, 1.Name(Str)  2.IsAvaiable(bool) 3.Price(double) 4.PcitureURL(str)
      }



    }
    for (Room r :rooms
    ) {
//      System.out.println(r.getName());
//      System.out.println(r.getPrice());
//      System.out.println(r.getAvailable());
//      System.out.println(r.getPictureUrl());

    }

    System.out.println("Rooms Read");
    Global.roomList= rooms;
  }


  }
