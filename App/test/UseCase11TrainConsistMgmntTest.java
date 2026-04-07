import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmntTest {

    Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
    Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

    boolean validateTrainId(String input) {
        Matcher matcher = trainIdPattern.matcher(input);
        return matcher.matches();
    }

    boolean validateCargoCode(String input) {
        Matcher matcher = cargoCodePattern.matcher(input);
        return matcher.matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrainId("TRAIN12"));
        assertFalse(validateTrainId("TRN12A"));
        assertFalse(validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validateTrainId("TRN-123"));
        assertFalse(validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(validateTrainId(""));
        assertFalse(validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(validateTrainId("TRN-1234extra"));
        assertFalse(validateCargoCode("PET-ABextra"));
    }
}