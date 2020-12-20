$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

$(document).ready(function () {
    $('#selectServiceType').change(function () {
        let option = $(this).find(':selected').text();
        switch (option) {
            case 'Villa':
                $("#standard").prop("disabled", false);
                $("#description").prop("disabled", false);
                $("#pool_area").prop("disabled", false);
                $("#floor").prop("disabled", false);
                break;
            case 'House':
                $("#standard").prop("disabled", false);
                $("#description").prop("disabled", false);
                $("#pool_area").prop("disabled", true);
                $("#floor").prop("disabled", false);
                break;
            case 'Room':
                $("#standard").prop("disabled", true);
                $("#description").prop("disabled", true);
                $("#pool_area").prop("disabled", true);
                $("#floor").prop("disabled", true);
        }
    })
});

$(document).ready(function () {
    if ($('#selectServiceType').val() == 3) {
        ("#standard").hide();
        $("#description").hide();
        $("#pool_area").hide();
        $("#floor").hide();
    }
    if ($('#selectServiceType').val() == 2) {
        $("#pool_area").hide();
    }
});

$('#btn').click(function () {
    // let servicePrice = parseInt($('#selectService option:selected').attr('data-price'));
    // let rentTypeCost = parseFloat($('#selectService option:selected').attr('date-renTypeCost'));
    let attachTotalCost = 0;
    let serviceTotalCost = 0;
    console.log(attachTotalCost);
    console.log(serviceTotalCost);
    let deposit, total = 0;
    let start = new Date($('#start').val()),
        end = new Date($('#end').val()),
        diff = new Date(end - start),
        days = diff / 1000 / 60 / 60 / 24;
    console.log(days);
    attachTotalCost = parseFloat($('#attachTotalCost').text());
    serviceTotalCost = parseFloat($('#serviceTotalCost').text());
    deposit = parseInt($('#deposit').val());
    total = days * serviceTotalCost - deposit + attachTotalCost;
    if (total < 0) {
        alert("The start date must be before the end date. Re-enter your start and end dates.");
    } else {
        $('#total').val(total);
    }
});


