package qaApiServices.patients;

public class BusinessIdentifiers {

    private String id;
    private String identifier;
    private String metadata;
    private String updated_at;
    private String identifier_type;
    private String created_at;
    private String deleted_at;
    private String metadata_version;

   public BusinessIdentifiers(){}

    public BusinessIdentifiers(String identifier, String metadata, String updated_at, String identifier_type, String created_at, String id, String deleted_at, String metadata_version) {
        this.identifier = identifier;
        this.metadata = metadata;
        this.updated_at = updated_at;
        this.identifier_type = identifier_type;
        this.created_at = created_at;
        this.id = id;
        this.deleted_at = deleted_at;
        this.metadata_version = metadata_version;
    }
}
