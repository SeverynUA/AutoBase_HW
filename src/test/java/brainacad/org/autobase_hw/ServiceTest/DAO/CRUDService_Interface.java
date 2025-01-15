package brainacad.org.autobuse_.ServiceTest.DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface CRUDService_Interface<T>
{
    @BeforeAll
    public static void checkDB()
    {

    }

    @BeforeEach
    public void setUp();

    @Test
    public void create_ReturnsClass_WhenValidInputProvided();

    @Test
    public void getById_ReturnsClass_WhenRequestExists();

    @Test
    public void delete_DoesNotThrow_WhenRequestExists();

    @AfterAll
    public static void clearDB()
    {

    }
}
