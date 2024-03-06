let displayValue;
if (employerDisabilityAdjustments === 0) {
    displayValue = 'N/A';
} else if (employerDisabilityAdjustments === 1) {
    displayValue = 'Yes';
} else if (employerDisabilityAdjustments === 2) {
    displayValue = 'No';
}
document.getElementById('employer-disability-value').innerHTML = displayValue;
let glicardValue;
if (gliCard === 0) {
    glicardValue = "Yes"
} else if (gliCard === 1) {
    glicardValue = "No"
} else if (gliCard === 2) {
    glicardValue = "N/A (country not in the EU)"
}
document.getElementById('health-card-value').innerHTML = glicardValue;

let riskAwareValue;
if (riskAware === 0) {
    riskAwareValue = "Yes"
} else if (riskAware === 1) {
    riskAwareValue = "No"
} else if (riskAware === 2) {
    riskAwareValue = "N/A (No risks)"
}
document.getElementById('risk-aware-value').innerHTML = riskAwareValue;
let worklocation;
if (confirmedWorkLocation === 0) {
    worklocation = "Yes"
} else if (confirmedWorkLocation === 1) {
    worklocation = "No"
}
document.getElementById('work-location-value').innerHTML = worklocation;

window.onload = function () {
    try {
        const displayValue = remoteWork === 1 ? 'Yes' : 'No';
        document.getElementById('remote-work-value').innerHTML = displayValue;

        if (remoteWork === 0) {
            const overviewDiv = document.getElementById('overview-div');
            const whyDiv = document.getElementById('why-div');
            overviewDiv.style.display = 'none';
            whyDiv.style.display = 'none';
        }
    } catch (error) {
        console.error(error);
    }
};
let Travelapplicationvalue;
if (travelapplication === false) {
    Travelapplicationvalue = "No"
} else if (travelapplication === true) {
    Travelapplicationvalue = "Yes"
}
document.getElementById('travel-application-value').innerHTML = Travelapplicationvalue;

let RiskassessmentValue;
if (riskassesment === false) {
    RiskassessmentValue = "No"
} else if (riskassesment === true) {
    RiskassessmentValue = "Yes"
}
document.getElementById('risk-assesment-value').innerHTML = RiskassessmentValue;

let MeasureAwareValue;
if (measureAware === false) {
    MeasureAwareValue = "No"
} else if (measureAware === true) {
    MeasureAwareValue = "Yes"
}
document.getElementById('measure-aware-value').innerHTML = MeasureAwareValue;

let safezoneValue;
if (safezone === true) {
    safezoneValue = "Yes"
} else if (safezone === false) {
    safezoneValue = "No"
}
document.getElementById('safe-zone-value').innerHTML = safezoneValue;

let fcdoinfoValue;
if (fcdoinfo === false) {
    fcdoinfoValue = "No"
} else if (fcdoinfo === true) {
    fcdoinfoValue = "Yes"
}
document.getElementById('fcdo-info-value').innerHTML = fcdoinfoValue;

let worklocationconfirmValue;
if (worklocationconfirmed === true) {
    worklocationconfirmValue = "Yes"
} else if (worklocationconfirmed === false) {
    worklocationconfirmValue = "No"
}
document.getElementById('work-location-confirmed-value').innerHTML = worklocationconfirmValue;

let OverseaseplacemtnValue;
if (overseaseplacement === true) {
    OverseaseplacemtnValue = "Yes"
} else if (overseaseplacement === false) {
    OverseaseplacemtnValue = "No"
}
document.getElementById('over-seas-value').innerHTML = OverseaseplacemtnValue;

let OverseasetravelGauide;
if (overseasTravelGuidance === true) {
    OverseasetravelGauide = "Yes"
} else if (overseasTravelGuidance === false) {
    OverseasetravelGauide = "No"
}
document.getElementById('over-seas-travel-Guide-value').innerHTML = OverseasetravelGauide;

let VisaDurationvalue;
if (visaduration === true) {
    VisaDurationvalue = "Yes"
} else if (visaduration === false) {
    VisaDurationvalue = "No"
}
document.getElementById('visa-duration-value').innerHTML = VisaDurationvalue;

let ProbationValue;
if (probationPeriod === true) {
    ProbationValue = "Yes"
} else if (probationPeriod === false) {
    ProbationValue = "No"
}
document.getElementById('probation-period-value').innerHTML = ProbationValue;

let ProviderInformedValue;
if (providerinformed === true) {
    ProviderInformedValue = "Yes"
} else if (providerinformed === false) {
    ProviderInformedValue = "No"
}
document.getElementById('provider-informaed-value').innerHTML = ProviderInformedValue;