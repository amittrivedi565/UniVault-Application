package com.microservice.universitycontentservice.Controller;

import com.microservice.universitycontentservice.DTO.BranchDTO;
import com.microservice.universitycontentservice.Entity.Branch;
import com.microservice.universitycontentservice.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<BranchDTO>> getAllBranchesController() {
        List<BranchDTO> allBranches = branchService.getAllBranches();
        return new ResponseEntity<>(allBranches, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchDTO> createBranchController(@RequestBody BranchDTO dto) {
        BranchDTO createdBranch = branchService.createBranch(dto);
        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
    }

    @DeleteMapping("/{branchId}")
    public ResponseEntity<String> deleteBranchController(@PathVariable UUID branchId) {
        branchService.deleteBranch(branchId);
        return ResponseEntity.ok("Branch deleted successfully");
    }

    @PutMapping("/{branchId}")
    public ResponseEntity<BranchDTO> updateBranchController(@PathVariable UUID branchId, @RequestBody Branch updatedBranchData) {
        BranchDTO updatedBranch = branchService.updateBranch(branchId, updatedBranchData);
        return ResponseEntity.ok(updatedBranch);
    }
}
