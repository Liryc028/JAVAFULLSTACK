import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common'; // Para *ngFor, *ngIf
import { FormsModule } from '@angular/forms';   // Para [(ngModel)]
import { Service } from './Servicio/service';   // Tu servicio
import Swal from 'sweetalert2';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule], // Importante importar esto
  templateUrl: './app.html',
  styleUrl: './app.css' // Ojo: en tu estructura dice 'styles.css' global, pero 'app.css' local. Si falla, borra esta línea.
})
export class App implements OnInit {
  title = 'AngularExamenReto';

  usuarios: any[] = [];

  usuario: any = {
    id: null,
    nombre: '',
    app: '',
    fechaNacimiento: '',
    telefono: '',
    email: ''
  };

  constructor(private service: Service, private cd: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.service.listar().subscribe(
      (data: any) => {
        // Tu backend devuelve: { success: true, obj: [...] }
        if (data && data.success) {
          this.usuarios = data.obj;
        } else {
          this.usuarios = [];
        }
        this.cd.detectChanges();
      },
      (error) => console.error(error)
    );
  }

  guardar() {
    // Si tiene ID, es editar
    if (this.usuario.id) {
      this.service.editar(this.usuario).subscribe(
        (data) => {
          Swal.fire('Actualizado', 'Usuario editado con éxito', 'success');
          this.listar();
          this.limpiar();
        },
        (error) => Swal.fire('Error', 'No se pudo editar', 'error')
      );
    } else {
      // Si no, es guardar nuevo
      this.service.guardar(this.usuario).subscribe(
        (data) => {
          Swal.fire('Guardado', 'Usuario guardado con éxito', 'success');
          this.listar();
          this.limpiar();
        },
        (error) => Swal.fire('Error', 'No se pudo guardar', 'error')
      );
    }
  }

  eliminar(id: number) {
    Swal.fire({
      title: '¿Eliminar usuario?',
      showCancelButton: true,
      confirmButtonText: 'Sí'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(id).subscribe(
          (data) => {
            Swal.fire('Eliminado', 'Usuario eliminado', 'success');
            this.listar();
          },
          (error) => Swal.fire('Error', 'No se pudo eliminar', 'error')
        );
      }
    });
  }

  cargarDatos(item: any) {
    this.usuario = { ...item }; // Copia para editar
  }

  limpiar() {
    this.usuario = {
      id: null,
      nombre: '',
      app: '',
      fechaNacimiento: '',
      telefono: '',
      email: ''
    };
  }
}