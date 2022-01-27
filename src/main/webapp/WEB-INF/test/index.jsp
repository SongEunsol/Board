<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
	<!DOCTYPE html>
	<html>

	<head>
		<script src="https://code.jquery.com/jquery-3.6.0.js"
			integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>

	<body>
		<div class="container">
			<div class="row align-items-start">
				<div class="form-floating col">
					<textarea class="form-control" placeholder="Leave a comment here" id="inputInfoArea"
						style="height: 500px">
{
    "no" : "test",
    "writer" : "test",
    "password" : "test",
    "title" : "test",
    "content" : "test2"
}
</textarea>
					<label for="floatingTextarea2">Input Info
					</label>
				</div>
				<div class="form-floating col">
					<textarea class="form-control" placeholder="Leave a comment here" id="outPutInfoArea"
						style="height: 500px"></textarea>
					<label for="floatingTextarea2">Output Info</label>
				</div>
			</div>
			<div class="right">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
						value="0" checked> <label class="form-check-label" for="flexRadioDefault1"> Get </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
						value="1"> <label class="form-check-label" for="flexRadioDefault2"> Post </label>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="API URL ex)db/getByID"
						aria-label="API URL ex)db/getByID" aria-describedby="button-addon2" id="apiUrl">
					<button class="btn btn-outline-secondary" type="button" id="button-submit">Submit</button>
				</div>
			</div>
		</div>
	</body>
	<script>
		$('#button-submit').on('click', function () {
			var apiUrl = $('#apiUrl').val();
			var apiParam = $('#inputInfoArea').val();
			var ajaxType = $('input[name=flexRadioDefault]:checked').val() == 0 ? "get" : "post";
			$.ajax({
				url: "api/" + apiUrl,
				type: ajaxType,
				dataType: "json",
				data: JSON.parse(apiParam),
				success: function (data) {
					$('#outPutInfoArea').val(JSON.stringify(data, null, 4));
				},
				error: function (error) {
					$('#outPutInfoArea').val(JSON.stringify(error, null, 4));
				}
			})
		});
	</script>

	</html>