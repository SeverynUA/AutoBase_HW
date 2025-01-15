package brainacad.org.autobase_hw.ServiceTest.DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class CRUDService_Abstract<T, R extends JpaRepository<T, Long>>
{
    protected static JpaRepository<?, ?> repository;

    @BeforeAll
    public static void checkDB()
    {
        System.out.println("Checking database connection...");
    }

    @BeforeEach
    public void setUp()
    {
        System.out.println("Setting up test environment...");
        repository.deleteAll();
    }

    @AfterAll
    public static void clearDB()
    {
        if (repository != null)
        {
            System.out.println("Clearing database after all tests...");
            repository.deleteAll();
        } else {
            System.out.println("Repository is not set; skipping clearDB.");
        }
    }
}
