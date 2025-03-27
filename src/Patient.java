
public class Patient {

	
	private String id;
    private String name;
    private String surname;
    private String gender;
    private String procedure;
    private String diagnosis;

    public Patient(String id, String name, String surname, String gender, String procedure, String diagnosis) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.procedure = procedure;
        this.diagnosis = diagnosis;
    }

    // Define getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getGender() { return gender; }
    public String getProcedure() { return procedure; }
    public String getDiagnosis() { return diagnosis; }
}
