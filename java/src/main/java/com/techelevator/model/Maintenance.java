package com.techelevator.model;

import org.w3c.dom.Text;

import java.time.LocalDate;

public class Maintenance {

    private Long maintenanceId;
    private Long ownershipId;
    private Long maintenanceStaffId;
    private Text description;
    private boolean complete;

    public Maintenance(Long maintenanceId, Long ownershipId, Long maintenanceStaffId, Text description, boolean complete, boolean assigned, boolean newRequest) {
        this.maintenanceId = maintenanceId;
        this.ownershipId = ownershipId;
        this.maintenanceStaffId = maintenanceStaffId;
        this.description = description;
        this.complete = complete;
        this.assigned = assigned;
        this.newRequest = newRequest;
    }



    // GETTERS SETTERS
    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Long getOwnershipId() {
        return ownershipId;
    }

    public void setOwnershipId(Long ownershipId) {
        this.ownershipId = ownershipId;
    }

    public Long getMaintenanceStaffId() {
        return maintenanceStaffId;
    }

    public void setMaintenanceStaffId(Long maintenanceStaffId) {
        this.maintenanceStaffId = maintenanceStaffId;
    }

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isNewRequest() {
        return newRequest;
    }

    public void setNewRequest(boolean newRequest) {
        this.newRequest = newRequest;
    }

    private boolean assigned;
    private boolean newRequest;

    //---------------methods---------------------------
    public String toString() {
        return "Maintenance{" +
                "maintenanceId=" + maintenanceId +
                ", ownershipId='" + ownershipId + //'\'' +
                ", maintenanceStaffId='" + maintenanceStaffId + //'\'' +
                ", description='" + description + //'\'' +
                ", complete='" + complete + //'\'' +
                ", assigned='" + assigned + //'\'' +
                ", newRequest='" + newRequest + //'\'' +
                '}';
    }



}
