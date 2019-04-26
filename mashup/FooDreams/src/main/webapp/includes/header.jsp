<div class="container-fluid bordered">
	<header class="header border-header">
		<div class="row d-flex align-items-center">
			<div class="col-sm-12 col-md-3">
				<div class="logo-container">
					<a href="/"><img class="img-fluid logo" src="images/logos/fooDreams-logo-md.png" alt="Logotipo de fooDreams" /></a>
				</div>
			</div>
			<div class="col-sm-12 col-md-7">
            	<form method="GET" action="SearchController">
                	<div class="form-row recipe-search">
                  		<div class="form-group col-md-5">
                      		<input type="text" name="q" class="form-control" placeholder="Buscar otra receta..." autofocus="autofocus" autocomplete="off">
                  		</div>
                  		<div class="form-group col-md-3">
                        	<select name="diet" class="form-control">
                            	<option value="">-- Tipo de dieta --</option>
                                <option value="balanced">Equilibrada</option>
								<option value="high-protein">Alta en proteina</option>
								<option value="low-fat">Baja en grasas</option>
								<option value="low-carb">Baja en carbohidratos</option>
                            </select>
                        </div>
                        <div class="form-group col-md-2">
                   			<input type="number" name="ingr" class="form-control" placeholder="Ingredientes máx.">
                    	</div>
                        <div class="form-group col-md-2">
                            <button class="btn btn-primary" type="submit"><i class="fas fa-search"></i> Buscar</button>
                        </div>
                    </div>  
            	</form>
			</div>
			<div class="col-sm-12 col-md-2">
				<div class="row d-flex justify-content-end pr-5">
					<form class="form-inline" action="">
						<button class="btn btn-primary">
							<i class="fab fa-youtube"></i> Mis playlists</button>
					</form>
				</div>
			</div>
		</div>
	</header>
</div>