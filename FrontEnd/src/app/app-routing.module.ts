import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ApplicationComponent } from './application/application.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { DocumentsComponent } from './documents/documents.component';
import { FaqComponent } from './faq/faq.component';
import { FeaturesComponent } from './features/features.component';
import { HomeComponent } from './home/home.component';
import { LoanTrackerComponent } from './loan-tracker/loan-tracker.component';
import { LoginComponent } from './login/login.component';
import { YourAccountComponent } from './your-account/your-account.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'about-us', component: AboutUsComponent
  },
  {
    path: 'calculator', component: CalculatorComponent
  },
  {
    path: 'application', loadChildren: () => import('./application/application.module').then(m => m.ApplicationModule)
  },
  {
    path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule)
  },
  {
    path: 'faq', component: FaqComponent
  },
  {
    path: 'features', component: FeaturesComponent
  },
  {
    path: 'documents', component: DocumentsComponent
  },
  {
    path: 'loan-tracker', component: LoanTrackerComponent
  },
  {
    path: 'admin-dashboard', component: AdminDashboardComponent
  },
  {
    path: 'your-account', component: YourAccountComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
