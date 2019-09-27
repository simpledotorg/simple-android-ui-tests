package qaApiServices.patients.builder;

import com.embibe.optimus.utils.ScenarioContext;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import utils.CreateGenerex;
import utils.Date;
import utils.ScenarioContextKeys;

@Getter
@Setter
public class BusinessIdentifiers {
    private String id;
    private String identifier;
    private String metadata;
    private String updated_at;
    private String identifier_type;
    private String created_at;
    private String deleted_at;
    private String metadata_version;

    public BusinessIdentifiers() {
    }

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

    public static class Builder{

        String userId = ScenarioContext.getData("User", ScenarioContextKeys.USER_ID);
        String facilityId = ScenarioContext.getData("User", ScenarioContextKeys.FACILTIYID);


        private String identifier = CreateGenerex.generex.random();
        private String metadata = "{\"assigning_user_id\": "+userId+",\"assigning_facility_id\": "+facilityId+"}";
        private String updated_at = Date.getCurrentDateIn_RFC339_Format();
        private String identifier_type = "simple_bp_passport";
        private String created_at = Date.getCurrentDateIn_RFC339_Format();
        private String id = CreateGenerex.generex.random();
        private String deleted_at = "";
        private String metadata_version = "org.simple.bppassport.meta.v1";

        public Builder(){ }

        public BusinessIdentifiers build(){

            return new BusinessIdentifiers(identifier,metadata,updated_at,identifier_type,created_at,id,deleted_at,metadata_version);
        }
    }
}
