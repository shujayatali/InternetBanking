function validate_open_account_form() {
	var name = document.open_account_form.name.value;
	var adhaar = document.open_account_form.adhaar.value;
	var mobile = document.open_account_form.mobile.value;
	var balance = document.open_account_form.bal.value;

	if (name == "") {
		alert("name should not be empty");
		document.open_account_form.name.focus();
		return false;
	} else if (adhaar.length != 12 || adhaar == "") {
		alert("Enter valid Adhaar Card Number");
		document.open_account_form.adhaar.focus();
		return false;
	} else if (mobile.length != 10 || mobile == "") {
		alert("Enter valid Mobile Number");
		document.open_account_form.mobile.focus();
		return false;
	} else if (balance == "" || balance <= 0) {
		alert("Enter valid Amount");
		document.open_account_form.bal.focus();
		return false;
	}
	return true;
}

function validate_accnum_balance() {
	var acc_num = document.creditdebitform.account_num.value;
	var acc_balance = document.creditdebitform.balance.value;
	if (acc_num == "" || acc_num.length != 11) {
		alert("Enter valid Account Number");
		document.creditdebitform.account_num.focus();
		return false;
	} else if (acc_balance <= 0 || acc_balance == "") {
		alert("Enter valid Amount");
		document.creditdebitform.balance.focus();
		return false;
	}

	return true;
}

function validate_accnum() {
	var acc_num = document.validateAccountNum.account_num.value;
	if (acc_num == "" || acc_num.length != 11) {
		alert("Enter valid Account Number");
		document.validateAccountNum.account_num.focus();
		return false;
	}
	return true;
}

function validate_sourceaccnum_destaccnum() {
	var source_acc_num = document.transferform.source_account_num.value;
	var dest_acc_num = document.transferform.dest_account_num.value;
	var balance = document.transferform.balance.value;

	if (source_acc_num == "" || source_acc_num.length != 11) {
		alert("Enter valid Source Account Number");
		document.transferform.source_account_num.focus();
		return false;
	} else if (dest_acc_num == "" || dest_acc_num.length != 11) {
		alert("Enter valid dest Account Number");
		document.transferform.dest_account_num.focus();
		return false;
	} else if (balance == "" || balance <= 0) {
		alert("Enter valid Amount");
		document.transferform.balance.focus();
		return false;
	}

	return true;
}
