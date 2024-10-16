<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="main">
	<div class="container">
		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-9">
			<h1>My account</h1>
			<div class="content-form-page">
				<div class="row">
					<c:if test="${alert !=null}">
						<h3 class="alert alert danger">${alert}</h3>
					</c:if>
					<div class="col-md-7 col-sm-7">
						<form action="/ltwebct4/myaccount" method="post"
							class="form-horizontal" role="form" enctype="multipart/form-data">
							<fieldset>
								<legend>Your personal details</legend>
								<!-- CHANGE AVATAR TAB -->

								<div class="fileinput fileinput-new" data-provides="fileinput">
									<div class="fileinput-new thumbnail"
										style="width: 200px; height: 150px; margin-left: 170px;">
										<img src="upload/${account.images}" alt="Ảnh mô tả" style="width: 100%; height: 100%;" />

									</div>
									<div class="form-group">
										<label for="image" class="col-lg-4 control-label">Image
											<span class="require">*</span>
										</label>

										<div class="col-lg-8">
											<input type="file" class="form-control" name="uploadFile" />
										</div>

									</div>

								</div>

								<!-- END CHANGE AVATAR TAB -->
								<div class="form-group">
									<label for="fullname" class="col-lg-4 control-label">Full
										Name <span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="fullname"
											name="fullname" value="${account.fullname}">
									</div>
								</div>
								<div class="form-group">
									<label for="phone" class="col-lg-4 control-label">Phone
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="tel" class="form-control" id="phone" name="phone"
											value="${account.phone}">
									</div>
								</div>
							</fieldset>

							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Update
										account</button>
									<button type="button" class="btn btn-default">Cancel</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-4 col-sm-4 pull-right">
						<div class="form-info">
							<h2>
								<em>Important</em> Information
							</h2>
							<p>Lorem ipsum dolor ut sit ame dolore adipiscing elit, sed
								sit nonumy nibh sed euismod ut laoreet dolore magna aliquarm
								erat sit volutpat. Nostrud exerci tation ullamcorper suscipit
								lobortis nisl aliquip commodo quat.</p>

							<p>Duis autem vel eum iriure at dolor vulputate velit esse
								vel molestie at dolore.</p>

							<button type="button" class="btn btn-default">More
								details</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
</div>