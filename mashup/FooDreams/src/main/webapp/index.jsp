<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>fooDreams - Página principal</title>
<%@ include file="includes/head.jsp" %>
    <div class="body-bg">
        <div class="body-filter-bg">
            <div class="container">
                <div class="row main-row pt-5">
                    <div class="col">
                        <!--Logotipo-->
                        <div class="row">
                            <div class="col text-center">
                                <img class="img-fluid" src="images/logos/fooDreams-logo-lg-w.png" alt="Logotipo de fooDreams" />
                            </div>
                        </div>
                        <!--fin logotipo-->

                        <!--Copy marketing-->
                        <div class="row copy-marketing">
                            <div class="col text-center">
                                <p class="lead p-2">Lorem ipsum dolor sit amet consectetur adipisicing elit</p>
                            </div>
                        </div>
                        <!--fin copy marketing-->

                        <!--Formulario de búsqueda-->
                        <div class="row justify-content-center">
                            <div class="col-md-8">
                                <form method="get" action="SearchController">
                                    <div class="form-row">
                                        <div class="form-group col-md-10 col-sm-9">
                                            <input type="text" name="q" class="form-control" placeholder="Buscar una receta" autofocus="autofocus">
                                        </div>
                                        <div class="form-group col-md-2 col-sm-3">
                                            <button class="btn btn-primary btn-block" type="submit">
                                                <i class="fas fa-search"></i> <span class="btn-search-text">Buscar</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-5 col-sm-6">
                                            <select name="diet" class="form-control">
                                            	<option value="">-- Tipo de dieta --</option>
                                                <option value="balanced">Equilibrada</option>
												<option value="high-protein">Alta en proteina</option>
												<option value="low-fat">Baja en grasas</option>
												<option value="low-carb">Baja en carbohidratos</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-5 col-sm-3">
                                            <input type="number" name="ingr" class="form-control" placeholder="Nº ingredientes máx.">
                                        </div>
                                    </div>  
                                </form>
                            </div>
                        </div>
                        <!--Fin formulario-->


                        <!--Login button-->
                        <div class="row mt-5 text-center">
                            <div class="col">
                                <button class="btn btn-primary btn-login" onclick="location.href='/youtubePlaylists'"><i class="fab fa-youtube"></i> Mis playlists de recetas</button>
                            </div>
                        </div>
                    </div>
                    <footer class="footer">
                        <p>&copy; 2019, <a href="about.html">fooDreams</a> 2MRC - AISS</p>
                    </footer>
                </div>
            </div>
        </div>    
    </div>
<%@ include file="includes/footer.jsp"%>