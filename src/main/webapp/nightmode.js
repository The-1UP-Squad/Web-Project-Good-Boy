var nightModeSwitch = document.getElementById("nightModeSwitch");
var isNightModeEnabled = false;

nightModeSwitch.addEventListener("click", function() {

    isNightModeEnabled = nightModeSwitch.checked;

    $("*").toggleClass("bg-dark text-light");

});