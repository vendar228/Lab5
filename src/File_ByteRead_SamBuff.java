public class File_ByteRead_SamBuff {
    // Считывание по 5 символов (буфер)
    public static void readAllByArray(InputStream in) throws IOException {
        byte [] buff = new byte[5];
        while (true) {
            int count = in.read(buff);
            if (count != -1) { // если не конец файла
                System.out.println("количество = " + count + ", buff = "
                        + Arrays.toString(buff) + ", str = "
                        + new String(buff, 0, count,"cp1251" )); //"UTF8"
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\MyFile1.txt";
        InputStream inFile = null;
        try {
            inFile = new FileInputStream(fileName);
            readAllyByArray(inFile);

        } catch (IOException e) {
            System.out.println("Ошибка открытия-закрытия файла " + filename+e);
        } finally { // корректное закрытие потока
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException ignore) {
                    /*NOP*/
                }
            } }}
