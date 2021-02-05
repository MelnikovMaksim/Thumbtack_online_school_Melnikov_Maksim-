package net.thumbtack.school.file;

import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.io.*;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class FileService {
    public static void  writeByteArrayToBinaryFile(String fileName, byte[] array)throws IOException{
        try (FileOutputStream fos = new FileOutputStream(fileName)){
            fos.write(array);
        }
    }

    public static void  writeByteArrayToBinaryFile(File file, byte[] array)throws IOException{
        writeByteArrayToBinaryFile(file.toString(),array);
    }

    public static byte[]  readByteArrayFromBinaryFile(String fileName)throws IOException{
        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] array = new byte[(int)Paths.get(fileName).toFile().length()];
            fis.read(array);
            return array;
        }
    }

    public static byte[]  readByteArrayFromBinaryFile(File file)throws IOException{
        return readByteArrayFromBinaryFile(file.toString());
    }

    public static byte[]  writeAndReadByteArrayUsingByteStream( byte[] array)throws IOException{
        byte[] byteArray;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            baos.write(array);
            byteArray = baos.toByteArray();
        }
        array = new byte[array.length/2];
        try (ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)){
            for (int i = 0; i<array.length; i++){
                array[i] = (byte) bais.read();
                bais.skip(1);
            }
        }
        return array;
    }

    public static void  writeByteArrayToBinaryFileBuffered(String fileName, byte[] array)throws IOException{
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))){
            bos.write(array);
        }
    }

    public static void  writeByteArrayToBinaryFileBuffered(File file, byte[] array)throws IOException{
        writeByteArrayToBinaryFileBuffered(file.toString(),array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException{
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] array = new byte[(int)Paths.get(fileName).toFile().length()];
            fis.read(array);
            return array;
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file)throws IOException{
        return readByteArrayFromBinaryFileBuffered(file.toString());
    }

    public static void  writeRectButtonToBinaryFile(File file, RectButton rectButton)throws IOException{
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(rectButton.getTopLeft().getX());
            dos.writeInt(rectButton.getTopLeft().getY());
            dos.writeInt(rectButton.getBottomRight().getX());
            dos.writeInt(rectButton.getBottomRight().getY());
            dos.writeUTF(rectButton.getState().toString());
            dos.writeUTF(rectButton.getText());
        }
    }

    public static RectButton readRectButtonFromBinaryFile(File file)throws WindowException, IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            return new RectButton(new Point(dis.readInt(),dis.readInt()), new Point(dis.readInt(),dis.readInt()), dis.readUTF(),dis.readUTF());
        }
    }

    public static void  writeRectButtonArrayToBinaryFile(File file, RectButton[] rects )throws IOException{
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (RectButton rectButton:rects) {
                dos.writeInt(rectButton.getTopLeft().getX());
                dos.writeInt(rectButton.getTopLeft().getY());
                dos.writeInt(rectButton.getBottomRight().getX());
                dos.writeInt(rectButton.getBottomRight().getY());
            }
        }
    }

    public static void  modifyRectButtonArrayInBinaryFile(File file)throws IOException{
        final int SIZE = (int)file.length()/16;
        try (RandomAccessFile raf = new RandomAccessFile(file,"rw")){
            int temp;
            for (int i = 0; i<SIZE*2; i++){
                temp = raf.readInt()+1;
                raf.seek(i*8);
                raf.writeInt(temp);
                raf.seek((i+1)*8);
            }
        }
    }

    public static RectButton[]  readRectButtonArrayFromBinaryFile(File file)throws WindowException, IOException{
        final int SIZE = (int)file.length()/16;
        RectButton[] rects = new RectButton[SIZE];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            for (int i = 0; i<SIZE; i++){
                rects[i] = new RectButton(new Point(dis.readInt(),dis.readInt()), new Point(dis.readInt(),dis.readInt()), WindowState.ACTIVE,"OK");
            }
        }
        return rects;
    }

    private static String formatRectButton(RectButton rectButton, String delimiter){
        return String.format("%d%s%d%s%d%s%d%s%s%s%s",  rectButton.getTopLeft().getX(), delimiter,
                                                        rectButton.getTopLeft().getY(), delimiter,
                                                        rectButton.getBottomRight().getX(), delimiter,
                                                        rectButton.getBottomRight().getY(), delimiter,
                                                        rectButton.getState().toString(), delimiter,
                                                        rectButton.getText());
    }

    public static void  writeRectButtonToTextFileOneLine(File file, RectButton rectButton)throws IOException{
        try (PrintStream ps = new PrintStream(file,"UTF-8")){
            ps.print(formatRectButton(rectButton," "));
        }
    }

    public static RectButton  readRectButtonFromTextFileOneLine(File file)throws WindowException,IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String[] rectButtonStrArr = br.readLine().split("\\s");
            return new RectButton(new Point(Integer.parseInt(rectButtonStrArr[0]),Integer.parseInt(rectButtonStrArr[1])),
                                    new Point(Integer.parseInt(rectButtonStrArr[2]),Integer.parseInt(rectButtonStrArr[3])),
                                    rectButtonStrArr[4],rectButtonStrArr[5]);
            }
    }

    public static void  writeRectButtonToTextFileSixLines(File file, RectButton rectButton)throws IOException{
        try (PrintStream ps = new PrintStream(file,"UTF-8")){
            ps.print(formatRectButton(rectButton,"\r\n"));
        }
    }

    public static RectButton  readRectButtonFromTextFileSixLines(File file)throws WindowException,IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            return new RectButton(new Point(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())),
                    new Point(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())),
                    br.readLine(),br.readLine());
        }
    }

    private static String formatTrainee(Trainee trainee, String delimiter){
        return String.format("%s%s%s%s%d",  trainee.getFirstName(), delimiter,
                                            trainee.getLastName(), delimiter,
                                            trainee.getRating());
    }

    public static void  writeTraineeToTextFileOneLine(File file, Trainee trainee)throws IOException{
        try (PrintStream ps = new PrintStream(file,"UTF-8")){
            ps.print(formatTrainee(trainee," "));
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file)throws NumberFormatException,TrainingException,IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
            String[] traineeStrArr = br.readLine().split("\\s");
            return new Trainee(traineeStrArr[0],traineeStrArr[1],Integer.parseInt(traineeStrArr[2]));
        }
    }

    public static void  writeTraineeToTextFileThreeLines(File file, Trainee trainee)throws IOException{
        try (PrintStream bw = new PrintStream(file,"UTF-8")){
            bw.print(formatTrainee(trainee,"\r\n"));
        }
    }

    public static Trainee  readTraineeFromTextFileThreeLines(File file)throws TrainingException,IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
            return new Trainee(br.readLine(),br.readLine(),Integer.parseInt(br.readLine()));
        }
    }

    public static void  serializeTraineeToBinaryFile(File file, Trainee trainee)throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(trainee);
        }
    }

    public static Trainee  deserializeTraineeFromBinaryFile(File file) throws ClassNotFoundException,IOException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (Trainee) ois.readObject();
        }
    }

    public static String  serializeTraineeToJsonString(Trainee trainee){
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee  deserializeTraineeFromJsonString(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void  serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            Gson gson = new Gson();
            gson.toJson(trainee,bw);
        }
    }

    public static Trainee  deserializeTraineeFromJsonFile(File file) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            Gson gson = new Gson();
            return gson.fromJson(br,Trainee.class);
        }
    }
}
