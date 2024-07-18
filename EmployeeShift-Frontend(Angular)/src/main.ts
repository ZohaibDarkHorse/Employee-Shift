import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideToastr } from 'ngx-toastr';

bootstrapApplication(AppComponent, {
  ...appConfig,
  providers: [
    provideAnimations(), // Required animations providers
    provideToastr(), // Toastr providers
    ...appConfig.providers, // Include other providers from appConfig if needed
  ],
}).catch((err) => console.error(err));
