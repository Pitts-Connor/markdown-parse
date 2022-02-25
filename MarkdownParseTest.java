import static org.junit.Assert.*;  //import necessary classes for testing
import org.junit.*; 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {  // class header
    @Test  // telling us that function on next line is a test
    public void addition() {  // method header
        assertEquals(2, 1 + 1);  // checks if 2 is equal to 1+1
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    // test-file test
    @Test
    public void testGetLinks() throws IOException {
        //right click on test-file.md in left sidebar to copy path
        // change \ to /
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    // test2-file test
    @Test
    public void testFile2() throws IOException {
        Path fileName = Path.of("test2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://duckduckgo.com", "https://kde.org"), links);
    }
    
    @Test
    public void testFile3() throws IOException {
        Path fileName = Path.of("test3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), links);
    }

    @Test
    public void testFile4() throws IOException {
        Path fileName = Path.of("test4.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), links);
    }

    @Test
    public void mytest() throws IOException{
        String contents= Files.readString(Path.of("test9-file.md"));
        List<String> expect = List.of();

        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("google.com","google.com","ucsd.edu"), links);
    }

   @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("a.com","b.com","example.com"), links);
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }

}
