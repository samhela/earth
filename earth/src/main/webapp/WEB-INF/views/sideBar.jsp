<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<!-- =============================================== -->

<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar" style="height: auto;">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left info">
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <sec:authorize access="hasRole('ADMIN')">
                <li class="treeview">
                    <a href="/user/userDashbord">
                        <i class="fa fa-user-md"></i><span>Manage Users</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/user/list"/>"><i class="fa fa-circle-o"></i>Users List</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/attendance/attendanceList"/>"><i class="fa fa-circle-o"></i>Students
                            Attendance</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/student"/>"><i class="fa fa-circle-o"></i>Students Dashboard
                            </a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/student/studentList"/>"><i class="fa fa-circle-o"></i>Students
                            List</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="/course/courseDashboard">
                        <i class="fa fa-user-md"></i> <span>Manage Course</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/course/courseList"/>"><i class="fa fa-circle-o"></i>Course List</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/course/offeringList"/>"><i class="fa fa-circle-o"></i>Course
                            Offerings</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="/location/list">
                        <i class="fa fa-user-md"></i> <span>Manage Location</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/location/locationList"/>"><i class="fa fa-circle-o"></i>Locations</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="/location/list">
                        <i class="fa fa-user-md"></i> <span>Manage Timeslot</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/timeslot/timeslotList"/>"><i class="fa fa-circle-o"></i>Time Slots</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="/location/list">
                        <i class="fa fa-user-md"></i> <span>Registration</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/registration/registrationList"/>"><i class="fa fa-circle-o"></i>Registrations</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasRole('STUDENT')">
                <li class="treeview">
                    <a href="/user/userDashbord">
                        <i class="fa fa-user-md"></i> <span>My Informations</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/attendance/myAttendace-${loggedinuser}"/>"><i class="fa fa-circle-o"></i>My Attendance List</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/course/courseListList"/>"><i class="fa fa-circle-o"></i>My Courses</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/user/update"/>"><i class="fa fa-circle-o"></i>Update profile</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasRole('PROFESSOR')">
                <li class="treeview">
                    <a href="/user/userDashbord">
                        <i class="fa fa-user-md"></i> <span>My Courses</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/course/list"/>"><i class="fa fa-circle-o"></i>Course List</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/user/attendance"/>"><i class="fa fa-circle-o"></i>Attendance</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/user/update"/>"><i class="fa fa-circle-o"></i>Update profile</a></li>
                    </ul>
                </li>
            </sec:authorize>

            <sec:authorize access="hasRole('FACULITY')">
             <li><a href="<c:url value="/course/courseList"/>"><i class="fa fa-circle-o"></i>View Course List</a></li>
             <li><a href="<c:url value="/faculty/studentList"/>"><i class="fa fa-circle-o"></i>View Student List </a></li>
            
             <!--    <li class="treeview">
                    <a href="/user/userDashbord">
                        <i class="fa fa-user-md"></i> <span>My Courses</span> <i
                            class="fa fa-angle-left pull-right"></i>
                    </a> -->
                 <%--    <ul class="treeview-menu">
                        <li><a href="<c:url value="/course/courseList"/>"><i class="fa fa-circle-o"></i>Course List</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/user/attendance"/>"><i class="fa fa-circle-o"></i>Attendance</a></li>
                    </ul>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/user/update"/>"><i class="fa fa-circle-o"></i>Update profile</a></li>
                    </ul> --%>
               <!--  </li> -->
            </sec:authorize>


        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

