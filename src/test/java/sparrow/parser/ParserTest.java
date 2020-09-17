package sparrow.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import sparrow.data.exceptions.IncorrectCommandException;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    public void parseCommand() {
        assertThrows(IncorrectCommandException.class, () -> {
            parser.parseCommand("");
        });

        assertThrows(IncorrectCommandException.class, () -> {
            parser.parseCommand("   ");
        });
    }
}