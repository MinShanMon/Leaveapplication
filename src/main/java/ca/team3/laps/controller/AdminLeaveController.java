package ca.team3.laps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.team3.laps.exception.AdminException;
import ca.team3.laps.model.Leave;
import ca.team3.laps.model.LeaveTypes.AnnualLeave;
import ca.team3.laps.model.LeaveTypes.CompensationLeave;
import ca.team3.laps.model.LeaveTypes.LeaveType;
import ca.team3.laps.model.LeaveTypes.MedicalLeave;
import ca.team3.laps.service.AdminLeaveService;
import ca.team3.laps.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class AdminLeaveController {

    @Autowired
    AdminLeaveService adminLeaveService;

    // POST/PUT/DELETE requests to manage leave types
    @PostMapping("/createannual")
    public ResponseEntity createAnnualLeaveEntitlement(@RequestBody AnnualLeave annualLeave) {
        try {
            AnnualLeave createdAnnualLeave = adminLeaveService.createAnnualLeaveEntitlement(annualLeave);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAnnualLeave);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/modifyannual")
    public ResponseEntity modifyAnnualLeaveEntitleMent(@RequestBody AnnualLeave annualLeave) {
        try {
            AnnualLeave modifiedAnnualLeave = adminLeaveService.modifyAnnualLeaveEntitlement(annualLeave);
            return ResponseEntity.status(HttpStatus.OK).body(modifiedAnnualLeave);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteannual")
    public ResponseEntity deleteAnnualLeaveEntitleMent(@RequestBody AnnualLeave annualLeave) {
        try {
            adminLeaveService.deleteAnnualLeaveEntitlement(annualLeave);
            return ResponseEntity.status(HttpStatus.OK).body("Annual Leave Entitlement has been deleted successfully");
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/createmedical")
    public ResponseEntity createMedicalLeaveEntitlement(@RequestBody MedicalLeave medicalLeave) {
        try {
            MedicalLeave createdMedicalLeave = adminLeaveService.createMedicalLeaveEntitlement(medicalLeave);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicalLeave);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/modifymedical")
    public ResponseEntity modifyMedicalLeaveEntitlement(@RequestBody MedicalLeave medicalLeave) {
        try {
            MedicalLeave modifiedMedicalLeaveEntitlement = adminLeaveService
                    .modifyMedicalLeaveEntitlement(medicalLeave);
            return ResponseEntity.status(HttpStatus.OK).body(modifiedMedicalLeaveEntitlement);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/createcomp")
    public ResponseEntity createCompLeaveEntitlement(@RequestBody CompensationLeave compensationLeave) {
        try {
            CompensationLeave createdCompLeave = adminLeaveService.createCompensationLeave(compensationLeave);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCompLeave);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/modifycomp")
    public ResponseEntity modifyCompLeaveEntitlement(@RequestBody CompensationLeave compensationLeave) {
        try {
            CompensationLeave modifiedCompLeave = adminLeaveService.modifyCompensationLeave(compensationLeave);
            return ResponseEntity.status(HttpStatus.OK).body(modifiedCompLeave);
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/entitlements")
    public ResponseEntity getLeaveEntitlements() {
        List<LeaveType> entitlements = adminLeaveService.getAllLeaveEntitlements();
        return ResponseEntity.status(HttpStatus.OK).body(entitlements);
    }

}
