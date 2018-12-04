<%@ page pageEncoding="ISO-8859-1"  contentType="text/html; charset=UTF-8" %>

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
<title>Customers | SM</title>

<div class="main-content-inner">
	<div class="breadcrumbs ace-save-state" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-home home-icon"></i>
				<a href="${contextPath}/admin/dashboard">Dashboard</a>
			</li>
			<li class="active">Customers List</li>
		</ul>

		<div class="nav-search" id="nav-search">
			<form class="form-search">
				<span class="input-icon">
					<!-- <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
					<i class="ace-icon fa fa-search nav-search-icon"></i> -->
				</span>
			</form>
		</div>
	</div>

	<div class="page-content">
		<div class="ace-settings-container" id="ace-settings-container">
			<!-- <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
				<i class="ace-icon fa fa-cog bigger-130"></i>
			</div> -->

			<div class="ace-settings-box clearfix" id="ace-settings-box">
				<div class="pull-left width-50">
					<div class="ace-settings-item">
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="no-skin" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; Choose Skin</span>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
						<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
						<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
						<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
						<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
						<label class="lbl" for="ace-settings-add-container">
							Inside
							<b>.container</b>
						</label>
					</div>
				</div>

				<div class="pull-left width-50">
					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
						<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
						<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
					</div>

					<div class="ace-settings-item">
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
						<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
					</div>
				</div>
			</div>
		</div>
				
					<div class="row">
						<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<h3 class="header smaller lighter blue">Customer Management</h3>
										
										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										<div class="table-header">
											Results for "Blogs List"
										</div>
										<!-- div.dataTables_borderWrap -->
										<div>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th class="center">
															<label class="pos-rel">
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</th>
														<th>Agnetname</th>
														<th>Email</th>
														<th>Mobile no</th>
														<th class="hidden-480">Office no</th>
														<th>Description</th>
														<th class="hidden-480">Status</th>
														<th class="hidden-480">Status</th>
													</tr>
												</thead>
												<tbody>
												  <c:forEach items="${userslist}"  var="customer"   varStatus="status">	
													<tr>
														<td class="center">
															<label class="pos-rel">
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</td>

														<td>
															<a href="#">${customer.firstname}</a>
														</td>
														<td>${customer.lastname}</td>
														<td>${customer.email}</td>
														<td class="hidden-480">${customer.mobile_no}</td>
														<td>${customer.username}</td>
                                                        <td>${customer.city}</td>
														<td>${customer.enabled}</td>
													</tr> 
													</c:forEach>  
												</tbody>
											</table>
										</div>
									</div>
								</div>
			</div>
		</div>
	</div>
</div>

</jsp:body>
</adminTemplate:adminDefaultDecorator>