package StudentDatabase;

import java.lang.Exception;

public class DuplicateException extends Exception
{
	DuplicateException()
	{
		System.err.println("Duplicate Record Found !");
	}
}
