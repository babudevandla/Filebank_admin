<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="adminTemplate" tagdir="/WEB-INF/tags"%>

<adminTemplate:adminDefaultDecorator>
<jsp:attribute name="title">Dashboard | SM</jsp:attribute>
<jsp:body>
<title>Dashboard | SM</title>


<div class="main-content-inner">
		<!-- #section:basics/content.breadcrumbs -->
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="${contextPath}/admin/dashboard">Home</a>
				</li>
				<li class="active">User Profile</li>
			</ul>
		</div>

		<div class="page-content">
			<div class="page-header">
				<h1>
					User Profile Page
					<small>
						<i class="ace-icon fa fa-angle-double-right"></i>
						
					</small>
				</h1>
			</div>

			<div class="row">
					<div>
						<div id="user-profile-1" class="user-profile row">
							<div class="col-xs-12 col-sm-3 center">
								<div>
									<!-- #section:pages/profile.picture -->
									<span class="profile-picture">
										<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="${contextPath}/resources/admin/dist/avatars/profile-pic.jpg" />
									</span>

									<!-- /section:pages/profile.picture -->
												<div class="space-4"></div>

												<div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
													<div class="inline position-relative">
														<a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
															<i class="ace-icon fa fa-circle light-green"></i>
															&nbsp;
															<span class="white">${user.firstName} &nbsp;${user.lastname}</span>
														</a>

														<ul class="align-left dropdown-menu dropdown-caret dropdown-lighter">
															<li class="dropdown-header"> Change Status </li>

															<li>
																<a href="#">
																	<i class="ace-icon fa fa-circle green"></i>
&nbsp;
																	<span class="green">Available</span>
																</a>
															</li>

															<li>
																<a href="#">
																	<i class="ace-icon fa fa-circle red"></i>
&nbsp;
																	<span class="red">Busy</span>
																</a>
															</li>

															<li>
																<a href="#">
																	<i class="ace-icon fa fa-circle grey"></i>
&nbsp;
																	<span class="grey">Invisible</span>
																</a>
															</li>
														</ul>
													</div>
												</div>
											</div>

											<div class="space-6"></div>

											<!-- #section:pages/profile.contact -->
								<div class="profile-contact-info">
									<div class="profile-contact-links align-left">
										<a href="#" class="btn btn-link">
											<i class="ace-icon fa fa-globe bigger-125 blue"></i>
											${user.email}
										</a>
									</div>

									<div class="space-6"></div>

									
								</div>

								<!-- /section:pages/profile.contact -->
								<div class="hr hr12 dotted"></div>

								
							</div>

							<div class="col-xs-12 col-sm-9">
								
								<div class="space-12"></div>

								<!-- #section:pages/profile.info -->
								<div class="profile-user-info profile-user-info-striped">
									<div class="profile-info-row">
										<div class="profile-info-name"> Username </div>

										<div class="profile-info-value">
											<span class="editable" id="username">${user.userName}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> Location </div>

										<div class="profile-info-value">
											<i class="fa fa-map-marker light-orange bigger-110"></i>
											<span class="editable" id="country">${user.city}</span>
											<span class="editable" id="city">${user.state}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> Age </div>

										<div class="profile-info-value">
											<span class="editable" id="age">38</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> Joined </div>

										<div class="profile-info-value">
											<span class="editable" id="signup">${user.createdDate}</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> Last Online </div>

										<div class="profile-info-value">
											<span class="editable" id="login">3 hours ago</span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name"> About Me </div>

										<div class="profile-info-value">
											<span class="editable" id="about">${user.about}</span>
										</div>
									</div>
								</div>

								<!-- /section:pages/profile.info -->
											<div class="space-20"></div>

											<div class="widget-box transparent">
												<div class="widget-header widget-header-small">
													<h4 class="widget-title blue smaller">
														<i class="ace-icon fa fa-rss orange"></i>
														Recent Activities
													</h4>

													<div class="widget-toolbar action-buttons">
														<a href="#" data-action="reload">
															<i class="ace-icon fa fa-refresh blue"></i>
														</a>
&nbsp;
														<a href="#" class="pink">
															<i class="ace-icon fa fa-trash-o"></i>
														</a>
													</div>
												</div>

												<div class="widget-body">
													<div class="widget-main padding-8">
														<!-- #section:pages/profile.feed -->
											<div id="profile-feed-1" class="profile-feed">
												<div class="profile-activity clearfix">
													<div>
														<img class="pull-left" alt="Alex Doe's avatar" src="${contextPath}/resources/admin/dist/avatars/avatar5.png" />
														<a class="user" href="#"> Alex Doe </a>
														changed his profile photo.
														<a href="#">Take a look</a>

														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															an hour ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<img class="pull-left" alt="Susan Smith's avatar" src="${contextPath}/resources/admin/dist/avatars/avatar1.png" />
														<a class="user" href="#"> Susan Smith </a>

														is now friends with Alex Doe.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															2 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<i class="pull-left thumbicon fa fa-check btn-success no-hover"></i>
														<a class="user" href="#"> Alex Doe </a>
														joined
														<a href="#">Country Music</a>

														group.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															5 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
														<a class="user" href="#"> Alex Doe </a>
														uploaded a new photo.
														<a href="#">Take a look</a>

														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															5 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<img class="pull-left" alt="David Palms's avatar" src="${contextPath}/resources/admin/dist/avatars/avatar4.png" />
														<a class="user" href="#"> David Palms </a>

														left a comment on Alex's wall.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															8 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<i class="pull-left thumbicon fa fa-pencil-square-o btn-pink no-hover"></i>
														<a class="user" href="#"> Alex Doe </a>
														published a new blog post.
														<a href="#">Read now</a>

														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															11 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<img class="pull-left" alt="Alex Doe's avatar" src="${contextPath}/resources/admin/dist/avatars/avatar5.png" />
														<a class="user" href="#"> Alex Doe </a>

														upgraded his skills.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															12 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<i class="pull-left thumbicon fa fa-key btn-info no-hover"></i>
														<a class="user" href="#"> Alex Doe </a>

														logged in.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															12 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<i class="pull-left thumbicon fa fa-power-off btn-inverse no-hover"></i>
														<a class="user" href="#"> Alex Doe </a>

														logged out.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															16 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>

												<div class="profile-activity clearfix">
													<div>
														<i class="pull-left thumbicon fa fa-key btn-info no-hover"></i>
														<a class="user" href="#"> Alex Doe </a>

														logged in.
														<div class="time">
															<i class="ace-icon fa fa-clock-o bigger-110"></i>
															16 hours ago
														</div>
													</div>

													<div class="tools action-buttons">
														<a href="#" class="blue">
															<i class="ace-icon fa fa-pencil bigger-125"></i>
														</a>

														<a href="#" class="red">
															<i class="ace-icon fa fa-times bigger-125"></i>
														</a>
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>

								<div class="hr hr2 hr-double"></div>

								<div class="space-6"></div>

								<div class="center">
									<button type="button" class="btn btn-sm btn-primary btn-white btn-round">
										<i class="ace-icon fa fa-rss bigger-150 middle orange2"></i>
										<span class="bigger-110">View more activities</span>

										<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<!-- PAGE CONTENT ENDS -->
				</div>
			</div>
		</div>
	
	
<script type="text/javascript">
	
	$('#profile-feed-1').ace_scroll({
		height: '250px',
		mouseWheelLock: true,
		alwaysVisible : true
	});
	
</script>	
		
	</jsp:body>
 </adminTemplate:adminDefaultDecorator>
 				