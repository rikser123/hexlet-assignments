package exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String resultFile) throws Exception {
        var firstContent = CompletableFuture.supplyAsync(() -> {
            var filePath = Paths.get(file1).toAbsolutePath().normalize();
            var fileContent = "";
            try {
                fileContent = Files.readString(filePath);
                return fileContent;
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
            return fileContent;
        });

        var secondContent = CompletableFuture.supplyAsync(() -> {
            var filePath = Paths.get(file2).toAbsolutePath().normalize();
            var fileContent = "";
            try {
                fileContent = Files.readString(filePath);
                return fileContent;
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
            return fileContent;
        });

        var allContent = firstContent.thenCombine(secondContent, (firstFileContent, secondFileContent) -> {
            var unionContent = Arrays.asList(firstFileContent, secondFileContent);
            var filePath = Paths.get(resultFile).toAbsolutePath().normalize();
            try {
                Files.write(filePath, unionContent, StandardCharsets.UTF_8);
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }

            return firstFileContent.concat(secondFileContent);
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return null;
        });

        return allContent;

    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        App.unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt ", "src/main/resources/burna.txt ");
        // END
    }
}

