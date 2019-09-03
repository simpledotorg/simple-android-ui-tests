package qaApiServices.appointments;

import lombok.Getter;
import lombok.Setter;
import utils.CreateGenerex;
import utils.Date;

@Getter
@Setter
public class Appointments {

    private String updated_at;
    private String appointment_type;
    private String patient_id;
    private String facility_id;
    private String created_at;
    private String id;
    private String scheduled_date;
    private String deleted_at;
    private String status;
    private String cancel_reason;
    private String agreed_to_visit;
    private String remind_on;

    public Appointments(){}


    public Appointments(String updated_at, String appointment_type, String patient_id, String facility_id, String created_at, String id, String scheduled_date, String deleted_at, String status,String cancel_reason, String agreed_to_visit,String remind_on) {
        this.updated_at = updated_at;
        this.appointment_type = appointment_type;
        this.patient_id = patient_id;
        this.facility_id = facility_id;
        this.created_at = created_at;
        this.id = id;
        this.scheduled_date = scheduled_date;
        this.deleted_at = deleted_at;
        this.status = status;
        this.cancel_reason = cancel_reason;
        this.agreed_to_visit = agreed_to_visit;
        this.remind_on=remind_on;
    }

    public static class Builder{
        private String updated_at=Date.getCurrentDateIn_RFC339_Format();
        private String appointment_type="manual";
        private String patient_id;
        private String facility_id;
        private String created_at=Date.getCurrentDateIn_RFC339_Format();
        private String id=CreateGenerex.generex.random();
        private String scheduled_date=Date.appointmentScheduleDate();
        private String deleted_at="";
        private String status="scheduled";
        private String cancel_reason;
        private String agreed_to_visit;
        private String remind_on;


        public Builder(){ }

        public Builder withAppointmentType(String value){
            this.appointment_type=value;
            return  this;
        }
        public Builder withStatus(String value){
            this.status=value;
            return  this;
        }
        public Builder withFacilityId(String value){
            this.facility_id=value;
            return  this;
        }
        public Builder withPatientId(String value){
            this.patient_id=value;
            return  this;
        }
        public Builder withCancelReason(String value){
            this.cancel_reason=value;
            return  this;
        }
        public Builder withAgreedToVisit(String value){
            this.agreed_to_visit=value;
            return  this;
        }
        public Builder withScheduled_date(String value){
            this.scheduled_date=value;
            return this;
        }

        public Builder withUpdatedAt(String value){
            this.scheduled_date=value;
            return this;
        }

        public Builder withCreatedAt(String value){
            this.scheduled_date=value;
            return this;
        }

        public Appointments build()
        {
            return new Appointments( updated_at, appointment_type, patient_id, facility_id, created_at, id, scheduled_date, deleted_at, status,cancel_reason,agreed_to_visit,remind_on);
        }
    }


}
