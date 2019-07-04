package constants;

public class QaApiUrl {

    public static final String BaseUrl="https://api-qa.simple.org/api/v3/";
    public static final String registerUser=BaseUrl+"users/register";
    public static final String registerBp=BaseUrl+"blood_pressures/sync";
    public static final String createAppointment=BaseUrl+ "appointments/sync";
    public static final String getFacility= BaseUrl+"facilities/sync";
    public static final String patient =BaseUrl+ "patients/sync";
    public static final String getProtocol= BaseUrl+"protocols/sync";
    public static final String getPrescriptionDrug=BaseUrl+"prescription_drugs/sync";
}
