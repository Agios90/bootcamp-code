$(document).ready(function() {
// $("#submit-button").click(function() {
//   alert(validCard($("#credit").value));
// });

$("#credit").change(function() {
  if (validCard($("#credit").val()) == false) {
    $("#submit-button").prop("disabled",true);
  } else {
    $("#submit-button").prop("disabled",false);
  }
});
});



function validCard(value) {
    if (/[^0-9-\s]+/.test(value)) return false;

    var nCheck = 0, nDigit = 0, bEven = false;
    value = value.replace(/\D/g, "");

    for (var n = value.length - 1; n >= 0; n--) {
        var cDigit = value.charAt(n),
            nDigit = parseInt(cDigit, 10);

        if (bEven) {
            if ((nDigit *= 2) > 9) nDigit -= 9;
        }

        nCheck += nDigit;
        bEven = !bEven;
    }

    return (nCheck % 10) == 0;
}
