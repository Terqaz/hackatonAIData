import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {
        List<String[]> csv = readCsv("csv\\short.csv");
//        printHeaders(csv.get(0));

        csv.remove(0);

        ReportMaker reportMaker = new ReportMaker()
                .addBlock("Общее количество прохождений Зачета",
                        csv.size())

                .addBlock("Общее количество уникальных участников Зачета",
                        csv.stream()
                                .map(s -> s[0]) // UIDn - код имени участника (коды присоены в алфавитном порядке)
                                .distinct().count())

                .addBlock("Количество уникальных участников Зачета, приступивших к прохождению по восьми " +
                                "подгруппам зачета в отдельности",
                        csv.stream().collect(Collectors.groupingBy(
                                s -> DataUtils.getSubgroupCategoriesMapping().get(s[9]).get(s[10]),
                                Collectors.counting()
                        )));

        System.out.println(reportMaker.toString());


//        Уровень педагогических знаний неравномерен по регионам России


//        Существуют вопросы вызывающие наибольшее затруднение у педагогов и родителей в целом по стране
//        Существует корреляция между педагогическим стажем и уровнем знаний педагогов
//        Существует корреляция между уровнем образования и уровнем педагогических знаний у родителей
//        Существует корреляция между количеством детей и уровнем педагогических знаний у родителей
//        Существует корреляция между возрастом и уровнем педагогических знаний у родителей
//        Родители являющиеся педагогами лучше сдают зачет
//        Женщины-родители лучше сдают зачет
//        Женщины-педагоги лучше сдают зачет
//        Доля сдавших зачет с первого раза - мала
    }

    private static List<String[]> readCsv(String path) throws IOException, CsvException {
        try (CSVReader reader = new CSVReaderBuilder(
                        Files.newBufferedReader(Path.of(path),  StandardCharsets.UTF_8))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            List<String[]> strings = reader.readAll();
            return strings;
        }
    }

    private static void printHeaders(String[] headers) {
        int i = 0;
        for (String s : headers)
            System.out.println(">> " + i++ + " " + s);
    }
}
