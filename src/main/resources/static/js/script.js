$(function(){

// User Register validation

	var $userRegister=$("#userRegister");

	$userRegister.validate({
		
		rules:{
			name:{
				required:true,

			}
			,
			email: {
				required: true,
				space: true,
				email: true
			},
			mobileNumber: {
				required: true,
				space: true,
				numericOnly: true,
				minlength: 10,
				maxlength: 12

			},
			password: {
				required: true,
				space: true

			},
			confirmpassword: {
				required: true,
				space: true,
				equalTo: '#pass'

			},
			address: {
				required: true,
			},

			city: {
				required: true,

			},
			state: {
				// required: true,

			},
			pincode: {
				required: true,
				space: true,
				numericOnly: true

			} 
			// , img: {
			// 	required: true,
			// }
			
		},
		messages:{
			name:{
				required:'name required',
				lettersonly:'invalid name'
			},
			email: {
				required: 'email name must be required',
				space: 'space not allowed',
				email: 'Vui lòng nhập lại email.'
			},
			mobileNumber: {
				required: 'Nhập số điện thoại',
				space: 'space not allowed',
				numericOnly: 'invalid mob no',
				minlength: 'min 10 digit',
				maxlength: 'max 12 digit'
			},

			password: {
				required: 'password must be required',
				space: 'Không được có dấu cách.'

			},
			confirmpassword: {
				required: 'confirm password must be required',
				space: 'Không được có dấu cách.',
				equalTo: 'Mật khẩu không trùng khớp.'

			},
			address: {
				required: 'address must be required',
				all: 'invalid'

			},

			city: {
				required: 'city must be required',
				space: 'Không được có dấu cách.'

			},
			state: {
				required: 'state must be required',
				space: 'space not allowed'

			},
			pincode: {
				required: 'pincode must be required',
				space: 'space not allowed',
				numericOnly: 'invalid pincode'

			},
			// img: {
			// 	required: 'image required',
			// }
		}
	})
	
	
// Orders Validation

var $orders=$("#orders");

$orders.validate({
		rules:{
			firstName:{
				required:true,
			},
			lastName:{
				required:true,
			}
			,
			email: {
				required: true,
				space: true,
				email: true
			},
			mobileNo: {
				required: true,
				space: true,
				numericOnly: true,
				minlength: 10,
				maxlength: 12

			},
			address: {
				required: true,

			},

			city: {
				required: true,

			},
			state: {
				// required: true,


			},
			pincode: {
				required: true,
				space: true,
				numericOnly: true

			},
			paymentType:{
			required: true
			}
		},
		messages:{
			firstName:{
				required:'Vui lòng nhập họ',
				lettersonly:'invalid name'
			},
			lastName:{
				required:'Vui lòng nhập tên',
				lettersonly:'invalid name'
			},
			email: {
				required: 'Vui lòng nhập email',
				space: 'space not allowed',
				email: 'Invalid email'
			},
			mobileNo: {
				required: 'Vui lòng nhập SĐT',
				space: 'space not allowed',
				numericOnly: 'invalid mob no',
				minlength: 'min 10 digit',
				maxlength: 'max 12 digit'
			}
		   ,
			address: {
				required: 'Vui lòng nhập địa chỉ',
				all: 'invalid'

			},

			city: {
				required: 'Vui lòng nhập thành phố',
				space: 'space not allowed'

			},
			state: {
				required: 'Vui lòng nhập quốc gia',
				space: 'space not allowed'

			},
			pincode: {
				required: 'Vui lòng nhập pincode',
				space: 'space not allowed',
				numericOnly: 'invalid pincode'

			},
			paymentType:{
			required: 'Lựa chọn phương thức'
			}
		}	
})

// Reset Password Validation

var $resetPassword=$("#resetPassword");

$resetPassword.validate({
		
		rules:{
			password: {
				required: true,
				space: true

			},
			confirmPassword: {
				required: true,
				space: true,
				equalTo: '#pass'

			}
		},
		messages:{
		   password: {
				required: 'password must be required',
				space: 'space not allowed'

			},
			confirmpassword: {
				required: 'confirm password must be required',
				space: 'space not allowed',
				equalTo: 'password mismatch'

			}
		}	
})



	
	
	
	
})



jQuery.validator.addMethod('lettersonly', function(value, element) {
		return /^[^-\s][a-zA-Z_\s-]+$/.test(value);
	});
	
		jQuery.validator.addMethod('space', function(value, element) {
		return /^[^-\s]+$/.test(value);
	});

	jQuery.validator.addMethod('all', function(value, element) {
		return /^[^-\s][a-zA-Z0-9_,.\s-]+$/.test(value);
	});


	jQuery.validator.addMethod('numericOnly', function(value, element) {
		return /^[0-9]+$/.test(value);
	});
