package in.cms.springbootcms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;    // return resource name that does not exist in the DB
	private String fieldName;       // return field name that does not exist in the DB
	private Object fieldValue;      // return field value that does not exist in the DB
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%S not found with %S : '%S'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	// Get methods
	public String getResourceName() 
	{
		return resourceName;
	}

	public String getFieldName() 
	{
		return fieldName;
	}

	public Object getFieldValue() 
	{
		return fieldValue;
	}

	
	
	

	
	
	
}
