package com.tcc.tccback.controller.dashboard;

import com.tcc.tccback.model.dashboard.dto.DashboardDTO;
import com.tcc.tccback.service.dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping()
    public ResponseEntity<DashboardDTO> geraDashboardInfo() {
        return new ResponseEntity<>(dashboardService.geraDashboardInfo(), HttpStatus.OK);
    }
}
