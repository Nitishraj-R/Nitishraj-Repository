
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, ViewEncapsulation, ViewChild, Input } from "@angular/core";

import { StepperComponent } from "@progress/kendo-angular-layout";

@Component({
  selector: 'app-asset-creation',
  templateUrl: './asset-creation.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./asset-creation.component.css']
})
export class AssetCreationComponent {

  listItems:Array<string>=[
    "assigned", 
    "unassigned"
  ]

  listType:Array<string>=[
    "Permanent",
    "Lease"
  ]

  listAsset:Array<string>=[
    'IT',
    "Fixed"
  ]

  listOperation:Array<string>=[
    "working",
    "not_working"
  ]

  listOs:Array<String>=[]
  
  public currentStep = 0;
  public basicDetails: FormGroup=new FormGroup({
    assetCode: new FormControl(""),
    assetName: new FormControl(""),
    usedBy: new FormControl(""),
    baseLocation: new FormControl(""),
    remark: new FormControl(""),

    serialNumber: new FormControl(""),
    status: new FormControl(""),
    operationalStatus: new FormControl(""),
    Category: new FormControl(""),
    assetType: new FormControl(""),
    cost: new FormControl(""),
    brand: new FormControl(""),
    modelNumber: new FormControl(""),

  });

  public assetDetails: FormGroup=new FormGroup({
    color: new FormControl(""),
    graphicsCard: new FormControl(""),
    ram: new FormControl(""),
    rom: new FormControl(""),
    processor: new FormControl(""),

    material: new FormControl(""),
    os: new FormControl(""),
    osVersion: new FormControl(""),
    battery: new FormControl(""),
    chargerType: new FormControl(""),
    wireless: new FormControl(""),
    weight: new FormControl(""),
    dimension: new FormControl(""),

    ipaddress: new FormControl(""),
    connectorType: new FormControl(""),
    blutoothVersion: new FormControl(""),
    chargingTime: new FormControl(""),
    capacity: new FormControl(""),
    size: new FormControl(""),
    watts: new FormControl(""),
    volt: new FormControl(""),

  });
  @ViewChild("stepper", { static: true })
  public stepper!: StepperComponent;

  private isStepValid = (index: number): boolean => {
    return this.getGroupAt(index).valid || this.currentGroup.untouched;
  };

  private shouldValidate = (index: number): boolean => {
    return this.getGroupAt(index).touched && this.currentStep >= index;
  };

  public steps = [
    {
      label: "Basic Details",
      isValid: this.isStepValid,
      validate: this.shouldValidate,
    },
    {
      label: "Asset Details",
      isValid: this.isStepValid,
      validate: this.shouldValidate,
    },
    {
      label: "Other Details",
      isValid: this.isStepValid,
      validate: this.shouldValidate,
    },
  ];

  public form = new FormGroup({
    accountDetails: new FormGroup({
      userName: new FormControl("", Validators.required),
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", Validators.required),
      avatar: new FormControl(null),
    }),
    assetDetails: new FormGroup({
      fullName: new FormControl(""),
      country: new FormControl(""),
      gender: new FormControl(null),
      about: new FormControl(""),
    }),
    paymentDetails: new FormGroup({
      cardNumber: new FormControl("", Validators.required),
      cvc: new FormControl("", [
        Validators.required,
        Validators.maxLength(3),
        Validators.minLength(3),
      ]),
      expirationDate: new FormControl("", Validators.required),
      cardHolder: new FormControl("", Validators.required),
    }),
  });

  public get currentGroup(): FormGroup {
    return this.getGroupAt(this.currentStep);
  }

  public next(): void {
    if (this.currentGroup.valid && this.currentStep !== this.steps.length) {
      this.currentStep += 1;
      return;
    }

    this.currentGroup.markAllAsTouched();
    this.stepper.validateSteps();
  }

  public prev(): void {
    this.currentStep -= 1;
  }

  public submit(): void {
    if (!this.currentGroup.valid) {
      this.currentGroup.markAllAsTouched();
      this.stepper.validateSteps();
    }
    if (this.form.valid) {
      console.log("Submitted data", this.form.value);
    }
  }

  private getGroupAt(index: number): FormGroup {
    const groups = Object.keys(this.form.controls).map((groupName) =>
      this.form.get(groupName)
    ) as FormGroup[];

    return groups[index];
  }
}
